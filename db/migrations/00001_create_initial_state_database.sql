CREATE TABLE account (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(255) NOT NULL,
	username VARCHAR(255) UNIQUE NOT NULL,
	comment_score VARCHAR(5) NOT NULL DEFAULT '50'
);

CREATE TABLE classification (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL
);

INSERT INTO classification(name) VALUES ('MUITO BOM');
INSERT INTO classification(name) VALUES ('BOM');
INSERT INTO classification(name) VALUES ('MÉDIO');
INSERT INTO classification(name) VALUES ('RUIM');
INSERT INTO classification(name) VALUES ('MUITO RUIM');
INSERT INTO classification(name) VALUES ('INDEFINIDO');

CREATE TABLE score (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(5) NOT NULL
);

INSERT INTO score(name) VALUES ('0');
INSERT INTO score(name) VALUES ('1');
INSERT INTO score(name) VALUES ('2');
INSERT INTO score(name) VALUES ('3');
INSERT INTO score(name) VALUES ('4');
INSERT INTO score(name) VALUES ('5');
INSERT INTO score(name) VALUES ('6');
INSERT INTO score(name) VALUES ('7');
INSERT INTO score(name) VALUES ('8');
INSERT INTO score(name) VALUES ('9');
INSERT INTO score(name) VALUES ('10');
INSERT INTO score(name) VALUES ('11');
INSERT INTO score(name) VALUES ('12');
INSERT INTO score(name) VALUES ('13');
INSERT INTO score(name) VALUES ('14');
INSERT INTO score(name) VALUES ('15');
INSERT INTO score(name) VALUES ('16');
INSERT INTO score(name) VALUES ('17');
INSERT INTO score(name) VALUES ('18');
INSERT INTO score(name) VALUES ('19');
INSERT INTO score(name) VALUES ('20');
INSERT INTO score(name) VALUES ('21');
INSERT INTO score(name) VALUES ('22');
INSERT INTO score(name) VALUES ('23');
INSERT INTO score(name) VALUES ('24');
INSERT INTO score(name) VALUES ('25');
INSERT INTO score(name) VALUES ('26');
INSERT INTO score(name) VALUES ('27');
INSERT INTO score(name) VALUES ('28');
INSERT INTO score(name) VALUES ('29');
INSERT INTO score(name) VALUES ('30');
INSERT INTO score(name) VALUES ('31');
INSERT INTO score(name) VALUES ('32');
INSERT INTO score(name) VALUES ('33');
INSERT INTO score(name) VALUES ('34');
INSERT INTO score(name) VALUES ('35');
INSERT INTO score(name) VALUES ('36');
INSERT INTO score(name) VALUES ('37');
INSERT INTO score(name) VALUES ('38');
INSERT INTO score(name) VALUES ('39');
INSERT INTO score(name) VALUES ('40');
INSERT INTO score(name) VALUES ('41');
INSERT INTO score(name) VALUES ('42');
INSERT INTO score(name) VALUES ('43');
INSERT INTO score(name) VALUES ('44');
INSERT INTO score(name) VALUES ('45');
INSERT INTO score(name) VALUES ('46');
INSERT INTO score(name) VALUES ('47');
INSERT INTO score(name) VALUES ('48');
INSERT INTO score(name) VALUES ('49');
INSERT INTO score(name) VALUES ('50');
INSERT INTO score(name) VALUES ('51');
INSERT INTO score(name) VALUES ('52');
INSERT INTO score(name) VALUES ('53');
INSERT INTO score(name) VALUES ('54');
INSERT INTO score(name) VALUES ('55');
INSERT INTO score(name) VALUES ('56');
INSERT INTO score(name) VALUES ('57');
INSERT INTO score(name) VALUES ('58');
INSERT INTO score(name) VALUES ('59');
INSERT INTO score(name) VALUES ('60');
INSERT INTO score(name) VALUES ('61');
INSERT INTO score(name) VALUES ('62');
INSERT INTO score(name) VALUES ('63');
INSERT INTO score(name) VALUES ('64');
INSERT INTO score(name) VALUES ('65');
INSERT INTO score(name) VALUES ('66');
INSERT INTO score(name) VALUES ('67');
INSERT INTO score(name) VALUES ('68');
INSERT INTO score(name) VALUES ('69');
INSERT INTO score(name) VALUES ('70');
INSERT INTO score(name) VALUES ('71');
INSERT INTO score(name) VALUES ('72');
INSERT INTO score(name) VALUES ('73');
INSERT INTO score(name) VALUES ('74');
INSERT INTO score(name) VALUES ('75');
INSERT INTO score(name) VALUES ('76');
INSERT INTO score(name) VALUES ('77');
INSERT INTO score(name) VALUES ('78');
INSERT INTO score(name) VALUES ('79');
INSERT INTO score(name) VALUES ('80');
INSERT INTO score(name) VALUES ('81');
INSERT INTO score(name) VALUES ('82');
INSERT INTO score(name) VALUES ('83');
INSERT INTO score(name) VALUES ('84');
INSERT INTO score(name) VALUES ('85');
INSERT INTO score(name) VALUES ('86');
INSERT INTO score(name) VALUES ('87');
INSERT INTO score(name) VALUES ('88');
INSERT INTO score(name) VALUES ('89');
INSERT INTO score(name) VALUES ('90');
INSERT INTO score(name) VALUES ('91');
INSERT INTO score(name) VALUES ('92');
INSERT INTO score(name) VALUES ('93');
INSERT INTO score(name) VALUES ('94');
INSERT INTO score(name) VALUES ('95');
INSERT INTO score(name) VALUES ('96');
INSERT INTO score(name) VALUES ('97');
INSERT INTO score(name) VALUES ('98');
INSERT INTO score(name) VALUES ('99');
INSERT INTO score(name) VALUES ('100');

CREATE TABLE product (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(255) NOT NULL,
	price BIGINT NOT NULL,
	description VARCHAR(500) NOT NULL
);

CREATE TABLE review (
	id SERIAL PRIMARY KEY NOT NULL,
	account_id INTEGER NOT NULL,
	product_id INTEGER NOT NULL,
	classification_id INTEGER NOT NULL,
	score_id INTEGER NOT NULL,
	comment VARCHAR(1000),

	CONSTRAINT account_id_fk
	FOREIGN KEY (account_id) REFERENCES account (id),

	CONSTRAINT product_id_fk
	FOREIGN KEY (product_id) REFERENCES product (id),

	CONSTRAINT classification_id_fk
	FOREIGN KEY (classification_id) REFERENCES classification (id),

	CONSTRAINT score_id_fk
	FOREIGN KEY (score_id) REFERENCES score (id)
);