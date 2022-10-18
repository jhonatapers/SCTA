insert into referencia_geografica (nome, latitude, longitude) values ('R31', 3,1);
insert into referencia_geografica (nome, latitude, longitude) values ('R51', 5,1);
insert into referencia_geografica (nome, latitude, longitude) values ('R71', 7,1);

insert into referencia_geografica (nome, latitude, longitude) values ('R22', 2,2);
insert into referencia_geografica (nome, latitude, longitude) values ('R92', 9,2);
insert into referencia_geografica (nome, latitude, longitude) values ('R53', 5,3);
insert into referencia_geografica (nome, latitude, longitude) values ('R73', 7,3);

insert into referencia_geografica (nome, latitude, longitude) values ('R14', 1,4);
insert into referencia_geografica (nome, latitude, longitude) values ('R34', 3,4);
insert into referencia_geografica (nome, latitude, longitude) values ('R84', 8,4);
insert into referencia_geografica (nome, latitude, longitude) values ('R55', 5,5);

insert into referencia_geografica (nome, latitude, longitude) values ('R26', 2,6);
insert into referencia_geografica (nome, latitude, longitude) values ('R46', 4,6);
insert into referencia_geografica (nome, latitude, longitude) values ('R86', 8,6);


insert into aeroporto values ('SDU', 'Santos Dummont', 'R71');
insert into aeroporto values ('GRU', 'Guarulhos', 'R22');
insert into aeroporto values ('CGH', 'Congonhas', 'R53');
insert into aeroporto values ('POA', 'Porto Alegre - Salgado Filho', 'R84');
insert into aeroporto values ('CGB', 'Marechal Rondon', 'R26');
insert into aeroporto values ('RBR', 'Plácido de Castro', 'R55');


insert into aerovia values ('AV1', 1000, 'R22', 'R31');
insert into aerovia values ('AV2', 1000, 'R31', 'R51');
insert into aerovia values ('AV3', 1000, 'R51', 'R71');
insert into aerovia values ('AV4', 1000, 'R22', 'R34');
insert into aerovia values ('AV5', 1000, 'R34', 'R51');
insert into aerovia values ('AV6', 1000, 'R51', 'R73');
insert into aerovia values ('AV7', 1000, 'R31', 'R53');
insert into aerovia values ('AV8', 1000, 'R51', 'R53');
insert into aerovia values ('AV9', 1000, 'R71', 'R73');
insert into aerovia values ('AV10', 1000, 'R71', 'R84');
insert into aerovia values ('AV11', 1000, 'R71', 'R92');
insert into aerovia values ('AV12', 1000, 'R92', 'R84');
insert into aerovia values ('AV13', 1000, 'R22', 'R55');
insert into aerovia values ('AV14', 1000, 'R22', 'R14');
insert into aerovia values ('AV15', 1000, 'R14', 'R26');
insert into aerovia values ('AV16', 1000, 'R26', 'R34');
insert into aerovia values ('AV17', 1000, 'R34', 'R53');
insert into aerovia values ('AV18', 1000, 'R34', 'R55');
insert into aerovia values ('AV19', 1000, 'R55', 'R46');
insert into aerovia values ('AV20', 1000, 'R46', 'R26');
insert into aerovia values ('AV21', 1000, 'R46', 'R86');
insert into aerovia values ('AV22', 1000, 'R86', 'R84');
insert into aerovia values ('AV23', 1000, 'R86', 'R73');
insert into aerovia values ('AV24', 1000, 'R86', 'R53');
insert into aerovia values ('AV25', 1000, 'R86', 'R55');
insert into aerovia values ('AV26', 1000, 'R55', 'R53');
insert into aerovia values ('AV27', 1000, 'R55', 'R73');
insert into aerovia values ('AV28', 1000, 'R53', 'R73');
insert into aerovia values ('AV29', 1000, 'R84', 'R73');
--insert into aerovia values ('AV30', 1000, 'R34', 'R46');


-- GRU -> SDU
insert into rota values (1);
insert into rota_aerovias VALUES (1, 'AV1');
insert into rota_aerovias values (1, 'AV2');
insert into rota_aerovias VALUES (1, 'AV3');

-- GRU -> SDU
insert into rota values (2);
insert into rota_aerovias VALUES (2, 'AV4');
insert into rota_aerovias VALUES (2, 'AV5');
insert into rota_aerovias VALUES (2, 'AV3');

-- GRU -> CGB
insert into rota values (3);
insert into rota_aerovias values (3, 'AV14');
insert into rota_aerovias values (3, 'AV15');

-- GRU -> CGB
insert into rota values (4);
insert into rota_aerovias values (4, 'AV4');
insert into rota_aerovias values (4, 'AV16');

-- GRU -> RBR
insert into rota values (5);
insert into rota_aerovias values (5, 'AV13');

-- GRU -> RBR
insert into rota values (6);
insert into rota_aerovias values (6, 'AV4');
insert into rota_aerovias values (6, 'AV18');

-- GRU -> CGH
insert into rota values (7);
insert into rota_aerovias values (7, 'AV4');
insert into rota_aerovias values (7, 'AV17');

-- GRU -> CGH
insert into rota values (8);
insert into rota_aerovias values (8, 'AV1');
insert into rota_aerovias values (8, 'AV7');

-- GRU -> CGH
insert into rota values (9);
insert into rota_aerovias values (9, 'AV1');
insert into rota_aerovias values (9, 'AV2');
insert into rota_aerovias values (9, 'AV8');

-- GRU -> CGH
insert into rota values (10);
insert into rota_aerovias values (10, 'AV4');
insert into rota_aerovias values (10, 'AV5');
insert into rota_aerovias values (10, 'AV8');

-- SDU -> CGH
insert into rota values (11);
insert into rota_aerovias values (11, 'AV3');
insert into rota_aerovias values (11, 'AV8');

-- SDU -> CGH
insert into rota values (12);
insert into rota_aerovias values (12, 'AV9');
insert into rota_aerovias values (12, 'AV28');

-- SDU -> CGH
insert into rota values (13);
insert into rota_aerovias values (13, 'AV9');
insert into rota_aerovias values (13, 'AV6');
insert into rota_aerovias values (13, 'AV8');

-- SDU -> CGH
insert into rota values (14);
insert into rota_aerovias values (14, 'AV3');
insert into rota_aerovias values (14, 'AV2');
insert into rota_aerovias values (14, 'AV7');

-- SDU -> CGH
insert into rota values (16);
insert into rota_aerovias values (16, 'AV3');
insert into rota_aerovias values (16, 'AV5');
insert into rota_aerovias values (16, 'AV17');

-- SDU -> CGH
insert into rota values (17);
insert into rota_aerovias values (17, 'AV9');
insert into rota_aerovias values (17, 'AV23');
insert into rota_aerovias values (17, 'AV24');

-- SDU -> POA
insert into rota values (18);
insert into rota_aerovias values (18, 'AV11');
insert into rota_aerovias values (18, 'AV12');

-- SDU -> POA
insert into rota values (19);
insert into rota_aerovias values (19, 'AV10');

-- SDU -> POA
insert into rota values (20);
insert into rota_aerovias values (20, 'AV9');
insert into rota_aerovias values (20, 'AV29');

-- SDU -> POA
insert into rota values (21);
insert into rota_aerovias values (21, 'AV9');
insert into rota_aerovias values (21, 'AV23');
insert into rota_aerovias values (21, 'AV22');

-- SDU -> POA
insert into rota values (22);
insert into rota_aerovias values (22, 'AV3');
insert into rota_aerovias values (22, 'AV6');
insert into rota_aerovias values (22, 'AV29');

-- SDU -> POA
insert into rota values (23);
insert into rota_aerovias values (23, 'AV3');
insert into rota_aerovias values (23, 'AV6');
insert into rota_aerovias values (23, 'AV23');
insert into rota_aerovias values (23, 'AV22');

-- SDU -> RBR
insert into rota values (24);
insert into rota_aerovias values (24, 'AV3');
insert into rota_aerovias values (24, 'AV5');
insert into rota_aerovias values (24, 'AV18');

-- SDU -> RBR
insert into rota values (25);
insert into rota_aerovias values (25, 'AV3');
insert into rota_aerovias values (25, 'AV6');
insert into rota_aerovias values (25, 'AV27');

-- SDU -> RBR
insert into rota values (26);
insert into rota_aerovias values (26, 'AV9');
insert into rota_aerovias values (26, 'AV23');
insert into rota_aerovias values (26, 'AV25');

-- SDU -> RBR
insert into rota values (27);
insert into rota_aerovias values (27, 'AV9');
insert into rota_aerovias values (27, 'AV23');
insert into rota_aerovias values (27, 'AV21');
insert into rota_aerovias values (27, 'AV19');

-- SDU -> CGB
insert into rota values (28);
insert into rota_aerovias values (28, 'AV3');
insert into rota_aerovias values (28, 'AV5');
insert into rota_aerovias values (28, 'AV16');

-- SDU -> CGB
insert into rota values (29);
insert into rota_aerovias values (29, 'AV9');
insert into rota_aerovias values (29, 'AV23');
insert into rota_aerovias values (29, 'AV21');
insert into rota_aerovias values (29, 'AV20');

-- SDU -> CGB
insert into rota values (30);
insert into rota_aerovias values (30, 'AV3');
insert into rota_aerovias values (30, 'AV6');
insert into rota_aerovias values (30, 'AV23');
insert into rota_aerovias values (30, 'AV21');
insert into rota_aerovias values (30, 'AV20');

-- SDU -> CGB
insert into rota values (31);
insert into rota_aerovias values (31, 'AV9');
insert into rota_aerovias values (31, 'AV6');
insert into rota_aerovias values (31, 'AV5');
insert into rota_aerovias values (31, 'AV16');

-- GRU -> POA
insert into rota values (32);
insert into rota_aerovias values (32, 'AV1');
insert into rota_aerovias values (32, 'AV2');
insert into rota_aerovias values (32, 'AV6');
insert into rota_aerovias values (32, 'AV29');

-- GRU -> POA
insert into rota values (33);
insert into rota_aerovias values (33, 'AV1');
insert into rota_aerovias values (33, 'AV2');
insert into rota_aerovias values (33, 'AV6');
insert into rota_aerovias values (33, 'AV23');
insert into rota_aerovias values (33, 'AV22');

-- GRU -> POA
insert into rota values (34);
insert into rota_aerovias values (34, 'AV4');
insert into rota_aerovias values (34, 'AV5');
insert into rota_aerovias values (34, 'AV6');
insert into rota_aerovias values (34, 'AV29');

-- GRU -> POA
insert into rota values (35);
insert into rota_aerovias values (35, 'AV4');
insert into rota_aerovias values (35, 'AV5');
insert into rota_aerovias values (35, 'AV6');
insert into rota_aerovias values (35, 'AV23');
insert into rota_aerovias values (35, 'AV22');

-- CGB -> RBR
insert into rota values (36);
insert into rota_aerovias values (36, 'AV20');
insert into rota_aerovias values (36, 'AV19');

-- CGB -> RBR
insert into rota values (37);
insert into rota_aerovias values (37, 'AV16');
insert into rota_aerovias values (37, 'AV18');

-- CGB -> RBR
insert into rota values (38);
insert into rota_aerovias values (38, 'AV20');
insert into rota_aerovias values (38, 'AV21');
insert into rota_aerovias values (38, 'AV25');

-- CGB -> RBR
insert into rota values (39);
insert into rota_aerovias values (39, 'AV20');
insert into rota_aerovias values (39, 'AV21');
insert into rota_aerovias values (39, 'AV23');
insert into rota_aerovias values (39, 'AV27');

-- CGB -> RBR
insert into rota values (40);
insert into rota_aerovias values (40, 'AV16');
insert into rota_aerovias values (40, 'AV5');
insert into rota_aerovias values (40, 'AV6');
insert into rota_aerovias values (40, 'AV27');

-- CGB -> RBR
insert into rota values (41);
insert into rota_aerovias values (41, 'AV16');
insert into rota_aerovias values (41, 'AV5');
insert into rota_aerovias values (41, 'AV6');
insert into rota_aerovias values (41, 'AV23');
insert into rota_aerovias values (41, 'AV25');

-- CGB -> RBR
insert into rota values (42);
insert into rota_aerovias values (42, 'AV16');
insert into rota_aerovias values (42, 'AV5');
insert into rota_aerovias values (42, 'AV6');
insert into rota_aerovias values (42, 'AV23');
insert into rota_aerovias values (42, 'AV21');
insert into rota_aerovias values (42, 'AV19');

-- CGB -> CGH
insert into rota values (43);
insert into rota_aerovias values (43, 'AV16');
insert into rota_aerovias values (43, 'AV17');

-- CGB -> CGH
insert into rota values (44);
insert into rota_aerovias values (44, 'AV16');
insert into rota_aerovias values (44, 'AV5');
insert into rota_aerovias values (44, 'AV8');

-- CGB -> CGH
insert into rota values (45);
insert into rota_aerovias values (45, 'AV16');
insert into rota_aerovias values (45, 'AV5');
insert into rota_aerovias values (45, 'AV6');
insert into rota_aerovias values (45, 'AV28');

-- CGB -> CGH
insert into rota values (46);
insert into rota_aerovias values (46, 'AV16');
insert into rota_aerovias values (46, 'AV5');
insert into rota_aerovias values (46, 'AV6');
insert into rota_aerovias values (46, 'AV23');
insert into rota_aerovias values (46, 'AV24');

-- CGB -> CGH
insert into rota values (47);
insert into rota_aerovias values (47, 'AV20');
insert into rota_aerovias values (47, 'AV21');
insert into rota_aerovias values (47, 'AV24');

-- CGB -> CGH
insert into rota values (48);
insert into rota_aerovias values (48, 'AV20');
insert into rota_aerovias values (48, 'AV21');
insert into rota_aerovias values (48, 'AV23');
insert into rota_aerovias values (48, 'AV28');

-- CGB -> CGH
insert into rota values (49);
insert into rota_aerovias values (49, 'AV20');
insert into rota_aerovias values (49, 'AV21');
insert into rota_aerovias values (49, 'AV23');
insert into rota_aerovias values (49, 'AV6');
insert into rota_aerovias values (49, 'AV8');

-- CGB -> CGH
insert into rota values (50);
insert into rota_aerovias values (50, 'AV20');
insert into rota_aerovias values (50, 'AV21');
insert into rota_aerovias values (50, 'AV23');
insert into rota_aerovias values (50, 'AV6');
insert into rota_aerovias values (50, 'AV2');
insert into rota_aerovias values (50, 'AV7');

-- CGB -> CGH
insert into rota values (51);
insert into rota_aerovias values (51, 'AV20');
insert into rota_aerovias values (51, 'AV21');
insert into rota_aerovias values (51, 'AV23');
insert into rota_aerovias values (51, 'AV6');
insert into rota_aerovias values (51, 'AV5');
insert into rota_aerovias values (51, 'AV17');

-- CGB -> POA
insert into rota values (52);
insert into rota_aerovias values (52, 'AV20');
insert into rota_aerovias values (52, 'AV21');
insert into rota_aerovias values (52, 'AV22');

-- CGB -> POA
insert into rota values (53);
insert into rota_aerovias values (53, 'AV20');
insert into rota_aerovias values (53, 'AV21');
insert into rota_aerovias values (53, 'AV23');
insert into rota_aerovias values (53, 'AV29');

-- CGB -> POA
insert into rota values (54);
insert into rota_aerovias values (54, 'AV16');
insert into rota_aerovias values (54, 'AV5');
insert into rota_aerovias values (54, 'AV6');
insert into rota_aerovias values (54, 'AV29');

-- CGB -> POA
insert into rota values (55);
insert into rota_aerovias values (54, 'AV16');
insert into rota_aerovias values (54, 'AV5');
insert into rota_aerovias values (54, 'AV6');
insert into rota_aerovias values (54, 'AV29');

-- POA -> CGH
insert into rota values (56);
insert into rota_aerovias values (56, 'AV29');
insert into rota_aerovias values (56, 'AV28');

-- POA -> CGH
insert into rota values (57);
insert into rota_aerovias values (57, 'AV22');
insert into rota_aerovias values (57, 'AV23');
insert into rota_aerovias values (57, 'AV28');

-- POA -> CGH
insert into rota values (58);
insert into rota_aerovias values (58, 'AV22');
insert into rota_aerovias values (58, 'AV24');

-- POA -> CGH
insert into rota values (59);
insert into rota_aerovias values (59, 'AV29');
insert into rota_aerovias values (59, 'AV6');
insert into rota_aerovias values (59, 'AV8');

-- POA -> CGH
insert into rota values (60);
insert into rota_aerovias values (60, 'AV29');
insert into rota_aerovias values (60, 'AV6');
insert into rota_aerovias values (60, 'AV2');
insert into rota_aerovias values (60, 'AV7');

-- POA -> CGH
insert into rota values (61);
insert into rota_aerovias values (61, 'AV29');
insert into rota_aerovias values (61, 'AV6');
insert into rota_aerovias values (61, 'AV5');
insert into rota_aerovias values (61, 'AV17');

-- POA -> RBR
insert into rota values (62);
insert into rota_aerovias values (62, 'AV22');
insert into rota_aerovias values (62, 'AV25');

-- POA -> RBR
insert into rota values (63);
insert into rota_aerovias values (63, 'AV22');
insert into rota_aerovias values (63, 'AV21');
insert into rota_aerovias values (63, 'AV19');

-- POA -> RBR
insert into rota values (64);
insert into rota_aerovias values (64, 'AV22');
insert into rota_aerovias values (64, 'AV23');
insert into rota_aerovias values (64, 'AV27');

-- POA -> RBR
insert into rota values (65);
insert into rota_aerovias values (65, 'AV29');
insert into rota_aerovias values (65, 'AV6');
insert into rota_aerovias values (65, 'AV5');
insert into rota_aerovias values (65, 'AV18');

-- CGH -> RBR
insert into rota values (66);
insert into rota_aerovias values (66, 'AV26');

-- CGH -> RBR
insert into rota values (67);
insert into rota_aerovias values (67, 'AV28');
insert into rota_aerovias values (67, 'AV27');

-- CGH -> RBR
insert into rota values (68);
insert into rota_aerovias values (68, 'AV24');
insert into rota_aerovias values (68, 'AV25');

-- CGH -> RBR
insert into rota values (69);
insert into rota_aerovias values (69, 'AV28');
insert into rota_aerovias values (69, 'AV23');
insert into rota_aerovias values (69, 'AV25');

-- CGH -> RBR
insert into rota values (70);
insert into rota_aerovias values (70, 'AV28');
insert into rota_aerovias values (70, 'AV23');
insert into rota_aerovias values (70, 'AV21');
insert into rota_aerovias values (70, 'AV19');

-- CGH -> RBR
insert into rota values (71);
insert into rota_aerovias values (71, 'AV28');
insert into rota_aerovias values (71, 'AV6');
insert into rota_aerovias values (71, 'AV5');
insert into rota_aerovias values (71, 'AV18');

-- CGH -> RBR
insert into rota values (72);
insert into rota_aerovias values (72, 'AV8');
insert into rota_aerovias values (72, 'AV5');
insert into rota_aerovias values (72, 'AV18');

-- CGH -> RBR
insert into rota values (73);
insert into rota_aerovias values (73, 'AV8');
insert into rota_aerovias values (73, 'AV6');
insert into rota_aerovias values (73, 'AV27');

-- CGH -> RBR
insert into rota values (74);
insert into rota_aerovias values (74, 'AV8');
insert into rota_aerovias values (74, 'AV6');
insert into rota_aerovias values (74, 'AV23');
insert into rota_aerovias values (74, 'AV25');

-- CGH -> RBR
insert into rota values (75);
insert into rota_aerovias values (75, 'AV8');
insert into rota_aerovias values (75, 'AV6');
insert into rota_aerovias values (75, 'AV23');
insert into rota_aerovias values (75, 'AV21');
insert into rota_aerovias values (75, 'AV19');

-- CGH -> RBR
insert into rota values (76);
insert into rota_aerovias values (76, 'AV17');
insert into rota_aerovias values (76, 'AV18');

-- CGH -> RBR
insert into rota values (77);
insert into rota_aerovias values (77, 'AV17');
insert into rota_aerovias values (77, 'AV5');
insert into rota_aerovias values (77, 'AV6');
insert into rota_aerovias values (77, 'AV27');

-- CGH -> RBR
insert into rota values (78);
insert into rota_aerovias values (78, 'AV17');
insert into rota_aerovias values (78, 'AV5');
insert into rota_aerovias values (78, 'AV6');
insert into rota_aerovias values (78, 'AV23');
insert into rota_aerovias values (78, 'AV25');

-- CGH -> RBR
insert into rota values (79);
insert into rota_aerovias values (79, 'AV17');
insert into rota_aerovias values (79, 'AV5');
insert into rota_aerovias values (79, 'AV6');
insert into rota_aerovias values (79, 'AV23');
insert into rota_aerovias values (79, 'AV21');
insert into rota_aerovias values (79, 'AV19');

-- RBR -> CGH
insert into rota values (80);
insert into rota_aerovias values (80, 'AV18');
insert into rota_aerovias values (80, 'AV5');
insert into rota_aerovias values (80, 'AV6');
insert into rota_aerovias values (80, 'AV27');

-- RBR -> CGH
insert into rota values (81);
insert into rota_aerovias values (81, 'AV18');
insert into rota_aerovias values (81, 'AV5');
insert into rota_aerovias values (81, 'AV6');
insert into rota_aerovias values (81, 'AV23');
insert into rota_aerovias values (81, 'AV25');

-- RBR -> CGH
insert into rota values (82);
insert into rota_aerovias values (82, 'AV18');
insert into rota_aerovias values (82, 'AV5');
insert into rota_aerovias values (82, 'AV6');
insert into rota_aerovias values (82, 'AV23');
insert into rota_aerovias values (82, 'AV21');
insert into rota_aerovias values (82, 'AV19');