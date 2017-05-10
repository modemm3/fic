package com.mx.fic.inventory.business.builder.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.persistent.BaseEntity;

/**
 * This class implements the singleton pattern, this class is responsible for loading all the available builders and
 * instantiating them. Implementing a proxy pattern the class is also responsible for the assembly of DTOs based on the
 * DTO class and Entity class.
 *
 * @author Modesto Mejia Martinez
 * @version 1.0
 * @since 1.0
 */
public final class TransferObjectAssembler {
    /** Class logger. */
    private static final Logger LOG = LoggerFactory.getLogger(TransferObjectAssembler.class);
    /** Package containing all the builders. */
    private static final String BUILDERS_PACKAGE = "com.tesis.tpv.ejb.builder";
    /** Map containing all the builders implementation. */
    private final Map<Class<?>, AbstractDTOBuilder> loadedBuilders;
    /** Unique instance of the builder. */
    private static TransferObjectAssembler instance;

    /**
     * Private constructor.
     * This constructor is responsible for loading all builders in the <code>com.cm.siveta.core.services.builder</code>
     * package, instantiates each builder and saves it in the <code>loadedBuilders</code>.
     */
    private TransferObjectAssembler() {
        LOG.info("Loading builders.");
        loadedBuilders = new HashMap<Class<?>, AbstractDTOBuilder>();
        final Reflections reflections = new Reflections(BUILDERS_PACKAGE);
        final Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(BuilderConfiguration.class, true);
        final Iterator<Class<?>> itAnnotated = annotated.iterator();
        final Class<?>[] noSignature = new Class[] {};
        final Object[] noParams = new Object[] {};
        Class<?> clazz;
        Constructor<?> constructor;
        BuilderConfiguration config;
        while (itAnnotated.hasNext()) {
            clazz = itAnnotated.next();
            LOG.info("loading builder: {}", clazz.getName());
            try {
                config = clazz.getAnnotation(BuilderConfiguration.class);
                constructor = clazz.getConstructor(noSignature);
                loadedBuilders.put(config.entityClass(),
                        (AbstractDTOBuilder) constructor.newInstance(noParams));
            } catch (Exception ex) {
                LOG.warn("Ignoring class: " + clazz.getName(), ex);
                continue;
            }
        }
    }

    /**
     * Searches the available builders using the entity class, if a builder is found, then its used to assemble the
     * data transfer object, else it returns null.
     *
     * @param dtoClass class of the data transfer object.
     * @param entity to use to assemble the BaseDTO.
     * @param <K> the concrete class of the data transfer object.
     * @param <E> the entity to use to assemble the transfer object.
     * @return the assembled DTO.
     */
    public <K extends BaseDTO, E extends BaseEntity> K assembleTO(final Class<K> dtoClass, final E entity) {
        final AbstractDTOBuilder builder = loadedBuilders.get(entity.getClass());
        LOG.info("builder {}", builder);
        
        BaseDTO dto = null;
        if (builder != null) {
            dto = builder.createDTO(entity);
        }
        return dto == null ? null : dtoClass.cast(dto);
    }

    /**
     * Returns the unique instance for the class BuilderFactory.
     *
     * @return  instance <code>BuilderFactory</code>
     */
    public static synchronized TransferObjectAssembler getInstance() {
        if (instance == null) {
            instance = new TransferObjectAssembler();
        }
        return instance;
    }

}