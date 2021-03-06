CREATE TABLE TYPE_PERSON (id  SERIAL NOT NULL, name int4 NOT NULL, description int4, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE TYPE_PERSON IS 'Tabla que guarda los tipos de persona como puede ser fisica o moral, entre otras';
COMMENT ON COLUMN TYPE_PERSON.id IS 'Id consecutivo del tipo de persona';
COMMENT ON COLUMN TYPE_PERSON.name IS 'Indica si el tipo de persona es física o moral';
COMMENT ON COLUMN TYPE_PERSON.description IS 'Breve descripción del tipo de persona';
COMMENT ON COLUMN TYPE_PERSON.company_id IS 'Id de la compañía a las que pertenecen registradas los tipos de persona';
CREATE TABLE VALUATION_TYPE (id  SERIAL NOT NULL, name varchar(100) NOT NULL, description varchar(255), key_valuation varchar(150) NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE VALUATION_TYPE IS 'Tabla que guarda los tipos de valuaciones como son primeras entradas y primeras salidas, entre otros registradas por los compañías';
COMMENT ON COLUMN VALUATION_TYPE.id IS 'Id consecutivo del tipo de valuación';
COMMENT ON COLUMN VALUATION_TYPE.name IS 'Indica el tipo de valuación como puede ser medicion, costo promedio, primeras entradas y primeras salidas u otros';
COMMENT ON COLUMN VALUATION_TYPE.description IS 'Breve descripción de la valuación';
COMMENT ON COLUMN VALUATION_TYPE.key_valuation IS 'Clave de la valuación como es VEPS, PEPS, etc';
COMMENT ON COLUMN VALUATION_TYPE.company_id IS 'Tiene el id compañía al cual le pertenece el tipo de valuación';
CREATE TABLE VALUATION (id  SERIAL NOT NULL, fiscal_exercise int4 NOT NULL, start_date timestamp NOT NULL, end_date timestamp NOT NULL, valuation_type_id int4 NOT NULL, company_id int4 NOT NULL, status_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE VALUATION IS 'Tiene las valuaciones que han registrado las compañías por ejercicio fiscal';
COMMENT ON COLUMN VALUATION.id IS 'Id consecutivo de la valuación asignada a la compañía';
COMMENT ON COLUMN VALUATION.fiscal_exercise IS 'Indica el año del ejercicio fiscal';
COMMENT ON COLUMN VALUATION.start_date IS 'fecha de inicio del ejercicio fiscal';
COMMENT ON COLUMN VALUATION.end_date IS 'fecha final del ejercicio fiscal';
COMMENT ON COLUMN VALUATION.valuation_type_id IS 'tipo de valuacion para la compañia, solo se puede seleccionar una única vez no podrá ser cambiado';
COMMENT ON COLUMN VALUATION.company_id IS 'Se guarda el id de la companía que le corresponde el tipo de valuación';
COMMENT ON COLUMN VALUATION.status_id IS 'indica el id del estatus que tiene la valuación para la compañía';
CREATE TABLE PROVIDER_ADDRESS (id  SERIAL NOT NULL, provider_id int4 NOT NULL, address_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE PROVIDER_ADDRESS IS 'Tabla que guarda la relación de las diferentes direcciones que tiene el proveedor';
COMMENT ON COLUMN PROVIDER_ADDRESS.id IS 'Id consecutivo que tiene la relación proveedor - dirección';
COMMENT ON COLUMN PROVIDER_ADDRESS.provider_id IS 'Id del proveedor al que pertenece la dirección';
COMMENT ON COLUMN PROVIDER_ADDRESS.address_id IS 'Id de la dirección del proveedor';
CREATE TABLE PROVIDER (id  SERIAL NOT NULL, name varchar(500) NOT NULL, last_name varchar(255), surname varchar(10), reason_social varchar(500), rfc varchar(100), email varchar(255), type_person_id int4 NOT NULL, status_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE PROVIDER IS 'Tabla que guarda los proveedores que se encuentran registrados en la compañía';
COMMENT ON COLUMN PROVIDER.id IS 'Id consecutivo del proveedor';
COMMENT ON COLUMN PROVIDER.name IS 'Nombre del proveedor';
COMMENT ON COLUMN PROVIDER.last_name IS 'Apellido paterno';
COMMENT ON COLUMN PROVIDER.surname IS 'Apellido materno';
COMMENT ON COLUMN PROVIDER.reason_social IS 'Razon social de como esta constituida la empresa';
COMMENT ON COLUMN PROVIDER.rfc IS 'Registro Federal del Contribuyente';
COMMENT ON COLUMN PROVIDER.email IS 'Correo electrónico del proveedor';
COMMENT ON COLUMN PROVIDER.type_person_id IS 'Id del tipo de persona a la que pertenece el proveedor';
COMMENT ON COLUMN PROVIDER.status_id IS 'Id del estatus del proveedor si esta Activo, Inactivo, Pendiente, etc.';
COMMENT ON COLUMN PROVIDER.company_id IS 'Id de la compañía de las cuales estan registrados los proveedores';
CREATE TABLE TIME_UNIT (id  SERIAL NOT NULL, name varchar(100), description varchar(255), company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE TIME_UNIT IS 'Tabla que guarda las unidades de tiempo como son los días, año. mes entre otros';
COMMENT ON COLUMN TIME_UNIT.id IS 'Id consecutivo de la unidad de tiempo';
COMMENT ON COLUMN TIME_UNIT.name IS 'Contienes si es días, mes, año, etc.';
COMMENT ON COLUMN TIME_UNIT.description IS 'Breve descripción de la unidad de tiempo';
COMMENT ON COLUMN TIME_UNIT.company_id IS 'Id de la compañía a la que pertenecen las unidades de tiempo';
CREATE TABLE MEASURE_UNIT (id  SERIAL NOT NULL, name varchar(255) NOT NULL, description varchar(255), company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE MEASURE_UNIT IS 'Tabla que guarda las unidades de  medida como son kilogramos, gramos, litros, entre otros';
COMMENT ON COLUMN MEASURE_UNIT.id IS 'Id consecutivo de la unidad de medida';
COMMENT ON COLUMN MEASURE_UNIT.name IS 'Indica la unidad de medida como pueden ser litros, gramos, kilogramos, piezas, entre otros';
COMMENT ON COLUMN MEASURE_UNIT.description IS 'Breve descripción de la unidad de medida';
COMMENT ON COLUMN MEASURE_UNIT.company_id IS 'Id de la compañía que le corresponden las unidades de medida';
CREATE TABLE STATUS (id  SERIAL NOT NULL, name varchar(100) NOT NULL, description varchar(255), company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE STATUS IS 'Tabla que guarda los diferentes estatus que maneja la compañía';
COMMENT ON COLUMN STATUS.id IS 'Id consecutivo de los estatus';
COMMENT ON COLUMN STATUS.name IS 'Se especifica si esta Activo, Inactivo, Pendiente o cualquier otro estatus';
COMMENT ON COLUMN STATUS.description IS 'Breve descripción de los estatus';
COMMENT ON COLUMN STATUS.company_id IS 'Id de la compañía a la que pertenecen los estatus';
CREATE TABLE COMPANY_ADDRESS (company_id int4 NOT NULL, address_id int4 NOT NULL, id  SERIAL NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE COMPANY_ADDRESS IS 'Tabla que guarda la relación de las direcciones que tiene la compañía';
COMMENT ON COLUMN COMPANY_ADDRESS.company_id IS 'Id de la compañía a la que pertenece la dirección';
COMMENT ON COLUMN COMPANY_ADDRESS.address_id IS 'Id de la dirección que pertenece la compañía';
COMMENT ON COLUMN COMPANY_ADDRESS.id IS 'Id consecutivo que tiene la relación de la compañía-dirección';
CREATE TABLE POSTAL_CODE (id  SERIAL NOT NULL, postal_code varchar(50) NOT NULL, state varchar(255) NOT NULL, town varchar(500) NOT NULL, city varchar(255) NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE POSTAL_CODE IS 'Tabla que guarda los códigos postales';
COMMENT ON COLUMN POSTAL_CODE.id IS 'Id consecutivo del código postal';
COMMENT ON COLUMN POSTAL_CODE.postal_code IS 'Código postal asignado al área geográfica';
COMMENT ON COLUMN POSTAL_CODE.state IS 'Nombre del estado';
COMMENT ON COLUMN POSTAL_CODE.town IS 'Nombre del municipio';
COMMENT ON COLUMN POSTAL_CODE.city IS 'Nombre de la ciudad';
CREATE TABLE TYPE_ADDRESS (id  SERIAL NOT NULL, name varchar(255) NOT NULL, description varchar(255), company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE TYPE_ADDRESS IS 'Tabla que guarda los tipos de direcciones como son particular, fiscal, entre otros';
COMMENT ON COLUMN TYPE_ADDRESS.id IS 'Id consecutivo del tipo de dirección';
COMMENT ON COLUMN TYPE_ADDRESS.name IS 'Tipo de dirección como puede ser fiscal, particular, etc';
COMMENT ON COLUMN TYPE_ADDRESS.description IS 'Breve descripción del tipo de dirección';
COMMENT ON COLUMN TYPE_ADDRESS.company_id IS 'Id de la compañía a las que pertenece el tipo de dirección';
CREATE TABLE ADDRESS (id  SERIAL NOT NULL, street varchar(255), colony varchar(255), exterior_number int4, interior_number int4, postal_code int4, town varchar(500), city varchar(255), state varchar(255), type_address_id int4 NOT NULL, status_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE ADDRESS IS 'Tabla que guarda las direcciones de los proveedores y compañías';
COMMENT ON COLUMN ADDRESS.id IS 'Id consecutivo de la dirección';
COMMENT ON COLUMN ADDRESS.street IS 'Nombre de la calle';
COMMENT ON COLUMN ADDRESS.colony IS 'Nombre de la colonia';
COMMENT ON COLUMN ADDRESS.exterior_number IS 'Número exterior';
COMMENT ON COLUMN ADDRESS.interior_number IS 'Número interior';
COMMENT ON COLUMN ADDRESS.postal_code IS 'Código postal';
COMMENT ON COLUMN ADDRESS.town IS 'Nombre del municipio';
COMMENT ON COLUMN ADDRESS.city IS 'Nombre de la ciudad';
COMMENT ON COLUMN ADDRESS.state IS 'Nombre de la ciudad';
COMMENT ON COLUMN ADDRESS.type_address_id IS 'Id del tipo de dirección';
COMMENT ON COLUMN ADDRESS.status_id IS 'Indica el estatus de la dirección si es activa, inactiva, temporal, etc';
COMMENT ON COLUMN ADDRESS.company_id IS 'Id de la compañía a la que pertenecen las direcciones registradas';
CREATE TABLE SEASON (id  SERIAL NOT NULL, name varchar(100) NOT NULL, description varchar(255), company_id int4 NOT NULL, start_date timestamp, end_date timestamp, PRIMARY KEY (id));
COMMENT ON TABLE SEASON IS 'Tabla que guarda las temporadas como son verano, julio regalado, entre otros';
COMMENT ON COLUMN SEASON.id IS 'Id consecutivo de la temporada';
COMMENT ON COLUMN SEASON.name IS 'Nombre de la temporada como puede ser verano,  decembrina, agosto al costo, julio regalado, entre otros';
COMMENT ON COLUMN SEASON.description IS 'Breve descripción de la temporada';
COMMENT ON COLUMN SEASON.company_id IS 'Id de la compañía que le corresponden las temporadas';
CREATE TABLE COMPANY (id  SERIAL NOT NULL, name varchar(255) NOT NULL, reason_social varchar(500) NOT NULL, rfc varchar(100), email varchar(255), status_id int4 NOT NULL, contact_name varchar(255), PRIMARY KEY (id));
COMMENT ON TABLE COMPANY IS 'Tabla que contiene todas las compañías que ingresan al sistema';
COMMENT ON COLUMN COMPANY.id IS 'Id consecutivo de la compañía';
COMMENT ON COLUMN COMPANY.name IS 'Nombre con los cuales fue constituida la empresa';
COMMENT ON COLUMN COMPANY.reason_social IS 'Nombre como se le conoce colectivamente a una empresa';
COMMENT ON COLUMN COMPANY.rfc IS 'Registro Federal del Contribuyente';
COMMENT ON COLUMN COMPANY.email IS 'email de la empresa';
COMMENT ON COLUMN COMPANY.status_id IS 'Estatus de la compañía si se encuentra Activa, Inactiva, Pendiente, etc.';
CREATE TABLE PRICES (id  SERIAL NOT NULL, type_price_id int4 NOT NULL, price numeric(19, 5) NOT NULL, product_id int4 NOT NULL, creation_date timestamp, season_id int4 NOT NULL, status_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE PRICES IS 'Tabla que guarda los precios registrados para los productos que maneja la compañía';
COMMENT ON COLUMN PRICES.id IS 'Id consecutivo del precio';
COMMENT ON COLUMN PRICES.type_price_id IS 'Id del tipo de precio';
COMMENT ON COLUMN PRICES.price IS 'Precio';
COMMENT ON COLUMN PRICES.product_id IS 'Id del producto al que pertenece el precio';
COMMENT ON COLUMN PRICES.creation_date IS 'Fecha de fin del precio que tiene el producto';
COMMENT ON COLUMN PRICES.season_id IS 'Id de la temporada en la que esta el precio disponible';
COMMENT ON COLUMN PRICES.status_id IS 'Estatus en el que se encuentra el precio para el producto';
COMMENT ON COLUMN PRICES.company_id IS 'Id de la compañía que registro los precios para dicho producto';
CREATE TABLE TYPE_PRICE (id  SERIAL NOT NULL, name varchar(200) NOT NULL, description varchar(255), status_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE TYPE_PRICE IS 'Tabla que guarda los tipos de precio como son precio especial, precio por cliente, entre otros';
COMMENT ON COLUMN TYPE_PRICE.id IS 'Id consecutivo del tipo de precio';
COMMENT ON COLUMN TYPE_PRICE.name IS 'Contiene los tipos de precio como son precio público en general, precio a mayoristas, precio al publico especial';
COMMENT ON COLUMN TYPE_PRICE.description IS 'Breve descripción del tipo de precio';
COMMENT ON COLUMN TYPE_PRICE.status_id IS 'Estatus del tipo de precio si es que se encuentra activo, inactivo, pendiente, etc';
COMMENT ON COLUMN TYPE_PRICE.company_id IS 'Indica el id de la compañía a la que pertenecen los tipos de precios';
CREATE TABLE PRODUCT (id  SERIAL NOT NULL, name varchar(500) NOT NULL, description varchar(255), barcode varchar(255), measure_unit_id int4 NOT NULL, status_id int4 NOT NULL, minimum_stock numeric(19, 5), maximum_stock numeric(19, 5), company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE PRODUCT IS 'Tabla que guarda los productos que maneja la compañía';
COMMENT ON COLUMN PRODUCT.id IS 'Id consecutivo del producto';
COMMENT ON COLUMN PRODUCT.name IS 'Nombre del producto';
COMMENT ON COLUMN PRODUCT.description IS 'Breve descripción del producto';
COMMENT ON COLUMN PRODUCT.barcode IS 'Código de barras del producto';
COMMENT ON COLUMN PRODUCT.measure_unit_id IS 'Indica la unidad de medida del producto como pueden ser litros, gramos, kilogramos, entre otros';
COMMENT ON COLUMN PRODUCT.status_id IS 'Id del estatus del producto si se encuentra activo, inactivo entre otro';
COMMENT ON COLUMN PRODUCT.minimum_stock IS 'Indica la cantidad minima a existir del producto';
COMMENT ON COLUMN PRODUCT.maximum_stock IS 'Indica la cantidad máxima permitida del producto';
COMMENT ON COLUMN PRODUCT.company_id IS 'Id de la compañía donde se registro el producto';
CREATE TABLE MOVEMENT_CONCEPT (id  SERIAL NOT NULL, name varchar(200) NOT NULL, description varchar(255), status_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE MOVEMENT_CONCEPT IS 'Tabla que guarda los conceptos de los movimientos como son las entradas, salidas, entre otros';
COMMENT ON COLUMN MOVEMENT_CONCEPT.id IS 'Id consecutivo del movimiento del concepto';
COMMENT ON COLUMN MOVEMENT_CONCEPT.name IS 'Nombre del concepto del movimiento como son compras, devolución, cambio producto, venta, robo, roturas, etc';
COMMENT ON COLUMN MOVEMENT_CONCEPT.description IS 'Breve descripción del concepto de movimiento';
COMMENT ON COLUMN MOVEMENT_CONCEPT.status_id IS 'Estatus del concepto de movimiento como es Activo, Inactivo, etc';
COMMENT ON COLUMN MOVEMENT_CONCEPT.company_id IS 'Id de la compañía a la que pertenecen los conceptos de los movimientos';
CREATE TABLE OPERATIONS (id  SERIAL NOT NULL, product_id int4 NOT NULL, movement_type_id int4 NOT NULL, status_id int4 NOT NULL, creation_date timestamp NOT NULL, stocks numeric(19, 5) NOT NULL, folio_document varchar(255), time_unit_id int4 NOT NULL, delivery_time numeric(19, 5), provider_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE OPERATIONS IS 'Tabla que guarda las operaciones de los movimientos de los productos';
COMMENT ON COLUMN OPERATIONS.id IS 'Id consecutivo de la operación';
COMMENT ON COLUMN OPERATIONS.product_id IS 'Id del producto a la que pertenece la operación';
COMMENT ON COLUMN OPERATIONS.movement_type_id IS 'Id del tipo de movimiento que presenta la operación';
COMMENT ON COLUMN OPERATIONS.status_id IS 'Id del estatus de la operación como puede ser Activa, Inactiva, Pendiente u otra';
COMMENT ON COLUMN OPERATIONS.creation_date IS 'Fecha de creación o movimiento de la operación';
COMMENT ON COLUMN OPERATIONS.stocks IS 'Indicador de cantidad existente del producto';
COMMENT ON COLUMN OPERATIONS.folio_document IS 'Folio de la nota de remisión o con que se identifique la operación';
COMMENT ON COLUMN OPERATIONS.time_unit_id IS 'Id de la unidad de tiempo que indica si son días, meses, año, etc';
COMMENT ON COLUMN OPERATIONS.delivery_time IS 'Indica el tiempo de entrega en de acuerdo al numero de días, mes o año previamente seleccionado';
COMMENT ON COLUMN OPERATIONS.provider_id IS 'Id del proveedor a la que pertenece la operación';
COMMENT ON COLUMN OPERATIONS.company_id IS 'Id de la compañía a la cual pertenece la operación';
CREATE TABLE MOVEMENT_TYPE (id  SERIAL NOT NULL, name varchar(255) NOT NULL, description varchar(255), movement_concept_id int4 NOT NULL, status_id int4 NOT NULL, company_id int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE MOVEMENT_TYPE IS 'Tabla que guarda los tipos de movimiento como son compras, ventas, devoluciones entre otros';
COMMENT ON COLUMN MOVEMENT_TYPE.id IS 'Id consecutivo del tipo de movimiento';
COMMENT ON COLUMN MOVEMENT_TYPE.name IS 'Nombre del tipo de movimiento como son Entradas, Salidas, etc';
ALTER TABLE OPERATIONS ADD CONSTRAINT FKOPERATIONS171819 FOREIGN KEY (product_id) REFERENCES PRODUCT (id);
ALTER TABLE OPERATIONS ADD CONSTRAINT FKOPERATIONS74527 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE OPERATIONS ADD CONSTRAINT FKOPERATIONS352960 FOREIGN KEY (movement_type_id) REFERENCES MOVEMENT_TYPE (id);
ALTER TABLE PRICES ADD CONSTRAINT FKPRICES47334 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE MOVEMENT_CONCEPT ADD CONSTRAINT FKMOVEMENT_C966524 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE PRODUCT ADD CONSTRAINT FKPRODUCT128766 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE TYPE_PRICE ADD CONSTRAINT FKTYPE_PRICE981624 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE VALUATION ADD CONSTRAINT FKVALUATION204077 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE ADDRESS ADD CONSTRAINT FKADDRESS90051 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE COMPANY_ADDRESS ADD CONSTRAINT FKCOMPANY_AD880858 FOREIGN KEY (address_id) REFERENCES ADDRESS (id);
ALTER TABLE PROVIDER_ADDRESS ADD CONSTRAINT FKPROVIDER_A693241 FOREIGN KEY (address_id) REFERENCES ADDRESS (id);
ALTER TABLE PROVIDER_ADDRESS ADD CONSTRAINT FKPROVIDER_A795642 FOREIGN KEY (provider_id) REFERENCES PROVIDER (id);
ALTER TABLE PRICES ADD CONSTRAINT FKPRICES855817 FOREIGN KEY (product_id) REFERENCES PRODUCT (id);
ALTER TABLE PRICES ADD CONSTRAINT FKPRICES572202 FOREIGN KEY (season_id) REFERENCES SEASON (id);
ALTER TABLE MOVEMENT_TYPE ADD CONSTRAINT FKMOVEMENT_T796942 FOREIGN KEY (movement_concept_id) REFERENCES MOVEMENT_CONCEPT (id);
ALTER TABLE OPERATIONS ADD CONSTRAINT FKOPERATIONS855608 FOREIGN KEY (provider_id) REFERENCES PROVIDER (id);
ALTER TABLE OPERATIONS ADD CONSTRAINT FKOPERATIONS810869 FOREIGN KEY (time_unit_id) REFERENCES TIME_UNIT (id);
ALTER TABLE PRODUCT ADD CONSTRAINT FKPRODUCT609314 FOREIGN KEY (measure_unit_id) REFERENCES MEASURE_UNIT (id);
ALTER TABLE ADDRESS ADD CONSTRAINT FKADDRESS180289 FOREIGN KEY (type_address_id) REFERENCES TYPE_ADDRESS (id);
ALTER TABLE PRICES ADD CONSTRAINT FKPRICES712099 FOREIGN KEY (type_price_id) REFERENCES TYPE_PRICE (id);
ALTER TABLE PROVIDER ADD CONSTRAINT FKPROVIDER580060 FOREIGN KEY (type_person_id) REFERENCES TYPE_PERSON (id);
ALTER TABLE VALUATION ADD CONSTRAINT FKVALUATION26170 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE VALUATION ADD CONSTRAINT FKVALUATION969222 FOREIGN KEY (valuation_type_id) REFERENCES VALUATION_TYPE (id);
ALTER TABLE PRICES ADD CONSTRAINT FKPRICES869426 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE TIME_UNIT ADD CONSTRAINT FKTIME_UNIT325602 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE MEASURE_UNIT ADD CONSTRAINT FKMEASURE_UN34020 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE SEASON ADD CONSTRAINT FKSEASON210320 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE PRICES ADD CONSTRAINT FKPRICES869427 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE TYPE_PRICE ADD CONSTRAINT FKTYPE_PRICE159532 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE PROVIDER ADD CONSTRAINT FKPROVIDER929325 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE TYPE_PERSON ADD CONSTRAINT FKTYPE_PERSO351159 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE TYPE_ADDRESS ADD CONSTRAINT FKTYPE_ADDRE960962 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE ADDRESS ADD CONSTRAINT FKADDRESS87856 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE PRODUCT ADD CONSTRAINT FKPRODUCT306673 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE MOVEMENT_CONCEPT ADD CONSTRAINT FKMOVEMENT_C144432 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE MOVEMENT_TYPE ADD CONSTRAINT FKMOVEMENT_T452505 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE VALUATION_TYPE ADD CONSTRAINT FKVALUATION_505472 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE COMPANY ADD CONSTRAINT FKCOMPANY88184 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE STATUS ADD CONSTRAINT FKSTATUS356339 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE COMPANY_ADDRESS ADD CONSTRAINT FKCOMPANY_AD433429 FOREIGN KEY (company_id) REFERENCES COMPANY (id);
ALTER TABLE MOVEMENT_TYPE ADD CONSTRAINT FKMOVEMENT_T274598 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE PROVIDER ADD CONSTRAINT FKPROVIDER751418 FOREIGN KEY (status_id) REFERENCES STATUS (id);
ALTER TABLE OPERATIONS ADD CONSTRAINT FKOPERATIONS896619 FOREIGN KEY (status_id) REFERENCES STATUS (id);

CREATE TABLE operational_module (id SERIAL NOT NULL, name varchar(50) NOT NULL, description varchar(255), "key" int4, active bool DEFAULT 'true' NOT NULL, creation_date timestamp NOT NULL, last_update timestamp, modify_by int4 NOT NULL, is_parent bool DEFAULT 'true' NOT NULL, class varchar(255), title varchar(255) NOT NULL, is_module bool DEFAULT 'true' NOT NULL, parent int4 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE operational_module IS 'Se encarga de almacenar las diferentes configuraciones para los modulos, menus, empresas y todo lo que se le puede mostrar al usuario';
COMMENT ON COLUMN operational_module.name IS 'Nombre del modulo';
COMMENT ON COLUMN operational_module.description IS 'Descripcion del modulo';
COMMENT ON COLUMN operational_module.active IS 'Indica si el modulo esta habilitado';
COMMENT ON COLUMN operational_module.creation_date IS 'Fecha de creacion del modulo';
COMMENT ON COLUMN operational_module.last_update IS 'Fecha de la ultima actualizacion';
COMMENT ON COLUMN operational_module.is_parent IS 'Indica si es un nodo hijo';
COMMENT ON COLUMN operational_module.class IS 'Almacena el nombre del controler';
COMMENT ON COLUMN operational_module.title IS 'Titulo del modulo';
COMMENT ON COLUMN operational_module.is_module IS 'Indica si es modulo';
CREATE TABLE password_history (id SERIAL NOT NULL, user_id int4 NOT NULL, password varchar(255) NOT NULL, active bool DEFAULT 'false' NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE password_history IS 'Almacena el historico de password';
COMMENT ON COLUMN password_history.user_id IS 'Usuario al cual esta relacionado el hsitorico de password';
COMMENT ON COLUMN password_history.password IS 'Password Anterior';
COMMENT ON COLUMN password_history.active IS 'estado del password';
CREATE TABLE permit_assignment (id SERIAL NOT NULL, user_id int4 NOT NULL, module_id int4 NOT NULL, company_id int4, PRIMARY KEY (id));
COMMENT ON TABLE permit_assignment IS 'Tabla intermedia para la asignacion de permisos al usuario.';
CREATE TABLE retries (id SERIAL NOT NULL, user_id int4 NOT NULL, retry int4 NOT NULL, max_retry int4 NOT NULL, minutes int4 NOT NULL, active bool DEFAULT 'true' NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE retries IS 'Almacena la configuracion de intentos por usuario, cada usuario puede tener n registro de intentos, cada registro de intentos debe de quedar en falso para bloquear el acceso del usuario. en caso de que el usuario notavia tenga registros activos, se le permitira todavia el acceso.';
COMMENT ON COLUMN retries.user_id IS 'Clave del usuario para quien se le va a confikgurar los reintentos';
COMMENT ON COLUMN retries.retry IS 'Numero de reintentos que lleva el usuario, este valor va ir incrementando hasta que el usuario ingrese la contraseña correcta';
COMMENT ON COLUMN retries.max_retry IS 'Numero de reintentos maximos antes de que el registro se desactive, si no existen mas registros para ese usuario el usario va a quedar bloqueado';
COMMENT ON COLUMN retries.minutes IS 'Numero de minutos entre reintentos';
COMMENT ON COLUMN retries.active IS 'Estado del registro. donde false será desahilitado';
CREATE TABLE secret_question (id SERIAL NOT NULL, question varchar(255) NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE secret_question IS 'Es un catalogo de preguntas en caso de que un usuario requiera recuperar su contraseña';
COMMENT ON COLUMN secret_question.question IS 'Es la pregunta que se le mostrara al usuario para su pregunta secreta';
CREATE TABLE sesssions (id SERIAL NOT NULL, user_id int4 NOT NULL, jsession_id varchar(255) NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE sesssions IS 'Almacena la session activa del usuario. solo va a existir una session por usuario, de tal forma que si un usuario se logue por segunda ocasión unas de las sessiones se va a cerrar';
COMMENT ON COLUMN sesssions.user_id IS 'id del usuario que esta con la session, este id es de latabla de usuarios';
COMMENT ON COLUMN sesssions.jsession_id IS 'Es el jsessionid de la aplicacion web';
CREATE TABLE "user" (id SERIAL NOT NULL, user_detail_id int4 NOT NULL, name varchar(50) NOT NULL, password varchar(255) NOT NULL, active bool DEFAULT 'true' NOT NULL, creation_date timestamp NOT NULL, modification_date timestamp, modify_by int4 NOT NULL, last_access timestamp, password_change_date timestamp, password_change_enable bool DEFAULT 'true' NOT NULL, question_secret_id int4 NOT NULL, response_secret varchar(255) NOT NULL, password_change_notification int4 DEFAULT 5 NOT NULL, PRIMARY KEY (id));
COMMENT ON TABLE "user" IS 'Almacena el registro de los usuarios permitidos en el sistema';
COMMENT ON COLUMN "user".user_detail_id IS 'Datos adicionales del usuario';
COMMENT ON COLUMN "user".name IS 'Nombre del usuario';
COMMENT ON COLUMN "user".password IS 'Password del usuario';
COMMENT ON COLUMN "user".active IS 'estado del usuario';
COMMENT ON COLUMN "user".creation_date IS 'Fecha de creacion del registro';
COMMENT ON COLUMN "user".modification_date IS 'Fecha de moldificacion del registro';
COMMENT ON COLUMN "user".modify_by IS 'Usuario que modifica el registro';
COMMENT ON COLUMN "user".last_access IS 'Se registra el ultimo acceso';
COMMENT ON COLUMN "user".password_change_date IS 'Fecha para el cambio de la contraseña';
COMMENT ON COLUMN "user".password_change_enable IS 'Habilita el cambio de password de forma periodica en el usuario';
COMMENT ON COLUMN "user".response_secret IS 'Respuesta secreta';
COMMENT ON COLUMN "user".password_change_notification IS 'Se indica el numero de dias antes del cambio de contraseña';
CREATE TABLE user_detail (id SERIAL NOT NULL, short_name varchar(50) NOT NULL, name varchar(100) NOT NULL, last_name varchar(50) NOT NULL, sur_name varchar(50), telephone varchar(30), address varchar(255), curp varchar(20), rfc varchar(20), last_access timestamp, email varchar(100), PRIMARY KEY (id));
COMMENT ON TABLE user_detail IS 'Almacena el detalle de los usuarios, datos adicionales';
COMMENT ON COLUMN user_detail.short_name IS 'Almacena el nombre corto para el usuario';
COMMENT ON COLUMN user_detail.name IS 'Nombre del usuario';
COMMENT ON COLUMN user_detail.last_name IS 'Apellido paterno';
COMMENT ON COLUMN user_detail.sur_name IS 'Apellido materno';
COMMENT ON COLUMN user_detail.telephone IS 'Telefono del usuario';
COMMENT ON COLUMN user_detail.address IS 'Direccion del usuario';
COMMENT ON COLUMN user_detail.curp IS 'Curp del usuario';
COMMENT ON COLUMN user_detail.rfc IS 'Rfc del usuario';
COMMENT ON COLUMN user_detail.last_access IS 'Fecha del ultimo acceso';
COMMENT ON COLUMN user_detail.email IS 'Correo electronico';
ALTER TABLE operational_module ADD CONSTRAINT FKoperationa600872 FOREIGN KEY (parent) REFERENCES operational_module (id);
ALTER TABLE password_history ADD CONSTRAINT FKpassword_h948446 FOREIGN KEY (user_id) REFERENCES "user" (id);
ALTER TABLE "user" ADD CONSTRAINT FKuser116410 FOREIGN KEY (question_secret_id) REFERENCES secret_question (id);
ALTER TABLE operational_module ADD CONSTRAINT FKoperationa463171 FOREIGN KEY (modify_by) REFERENCES "user" (id);
ALTER TABLE permit_assignment ADD CONSTRAINT FKpermit_ass576872 FOREIGN KEY (module_id) REFERENCES operational_module (id);
ALTER TABLE permit_assignment ADD CONSTRAINT FKpermit_ass613297 FOREIGN KEY (user_id) REFERENCES "user" (id);
ALTER TABLE "user" ADD CONSTRAINT FKuser375160 FOREIGN KEY (modify_by) REFERENCES "user" (id);
ALTER TABLE "user" ADD CONSTRAINT FKuser662691 FOREIGN KEY (user_detail_id) REFERENCES user_detail (id);
ALTER TABLE retries ADD CONSTRAINT FKretries848245 FOREIGN KEY (user_id) REFERENCES "user" (id);
ALTER TABLE sesssions ADD CONSTRAINT FKsesssions325626 FOREIGN KEY (user_id) REFERENCES "user" (id);
