insert into categorie(categorie) values ('Sport');
insert into categorie(categorie) values ('Luxury');
insert into categorie(categorie) values ('Coupe');
insert into categorie(categorie) values ('Sedan');
insert into categorie(categorie) values ('Hatchback');

insert into firma values (null,'Fiat');
insert into firma values (null,'Mercedes');
insert into firma values (null,'Audi');

--INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('an', 'cap', 'cul', 'fir',  'model',  'CT 01 RNT',  'put',  'pre', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2007', '1900', 'Negru', '1',  'Bravo',  'CT 01 RNT',  '125',  '120', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2018', '3500', 'Gri',  '2',  'S-AMG',  'CT 02 RNT',  '330',  '350', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2018', '2500', 'Alb', '2',  'C Class',  'CT 03 RNT',  '350',  '180', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2012', '1900', 'Rosu', '3',  'A3',  'CT 04 RNT',  '130',  '125', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2010', '2000', 'Negru',  '3',  'A4',  'CT 05 RNT',  '125',  '125', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2010', '200', 'Alb', '3',  'A4',  'CT 06 RNT',  '135',  '125', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2007', '1900', 'Negru', '1',  'Bravo',  'CT 07 RNT',  '120',  '125', false);
INSERT INTO masina (an_productie, capacitate_cilindrica, culoare,  firma_id, model, numar_inmatriculare, pret, putere, este_inchiriata ) VALUES ('2007', '1900', 'Negru', '1',  'Bravo',  'CT 08 RNT',  '120',  '125', false);

insert into angajat(cnp, nume, prenume, varsta) values ('1980305134126', 'Adrian', 'Cirmaciu', '26')
insert into angajat(cnp, nume, prenume, varsta) values ('1421305134126', 'Marian', 'Vasile', '26')

insert into categorie_masina(masina_id, categorie_id) values('8', '5')
insert into categorie_masina(masina_id, categorie_id) values('8', '1')
insert into categorie_masina(masina_id, categorie_id) values('7', '5')
insert into categorie_masina(masina_id, categorie_id) values('7', '1')
insert into categorie_masina(masina_id, categorie_id) values('6', '5')
insert into categorie_masina(masina_id, categorie_id) values('6', '3')
insert into categorie_masina(masina_id, categorie_id) values('5', '4')
insert into categorie_masina(masina_id, categorie_id) values('4', '5')
insert into categorie_masina(masina_id, categorie_id) values('4', '3')
insert into categorie_masina(masina_id, categorie_id) values('3', '4')
insert into categorie_masina(masina_id, categorie_id) values('3', '2')
insert into categorie_masina(masina_id, categorie_id) values('2', '2')
insert into categorie_masina(masina_id, categorie_id) values('2', '1')
insert into categorie_masina(masina_id, categorie_id) values('1', '5')
insert into categorie_masina(masina_id, categorie_id) values('1', '1')



