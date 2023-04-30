BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "TEST" (
	"PlayerID"	INTEGER,
	"PlayerName"	TEXT,
	PRIMARY KEY("PlayerID")
);
CREATE TABLE IF NOT EXISTS "Teams" (
	"Team_id"	TEXT,
	PRIMARY KEY("Team_id")
);
CREATE TABLE IF NOT EXISTS "Positions" (
	"Position_id"	TEXT,
	PRIMARY KEY("Position_id")
);
CREATE TABLE IF NOT EXISTS "Games" (
	"Game_id"	INTEGER,
	"Game_team_one_id"	TEXT NOT NULL,
	"Game_team_two_id"	TEXT NOT NULL,
	"Game_win_id"	TEXT NOT NULL,
	"Game_team_one_score"	INTEGER NOT NULL,
	"Game_team_two_score"	INTEGER NOT NULL,
	"Game_date"	TEXT NOT NULL,
	FOREIGN KEY("Game_team_two_id") REFERENCES "Teams"("Team_id"),
	FOREIGN KEY("Game_team_one_id") REFERENCES "Teams"("Team_id"),
	FOREIGN KEY("Game_win_id") REFERENCES "Teams"("Team_id"),
	PRIMARY KEY("Game_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Players" (
	"Player_id"	INTEGER,
	"Player_last_name"	TEXT NOT NULL,
	"Player_first_name"	TEXT NOT NULL,
	"Player_team_id"	TEXT NOT NULL,
	FOREIGN KEY("Player_team_id") REFERENCES "Teams"("Team_id"),
	PRIMARY KEY("Player_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Batter_Stats" (
	"Batter_stat_id"	INTEGER,
	"Batter_stat_game_id"	TEXT NOT NULL,
	"Batter_stat_team_id"	TEXT NOT NULL,
	"Batter_stat_player_id"	INTEGER NOT NULL,
	"Batter_stat_pos_id"	TEXT NOT NULL,
	"Batter_stat_ab"	INTEGER NOT NULL,
	"Batter_stat_runs"	INTEGER NOT NULL,
	"Batter_stat_hits"	INTEGER NOT NULL,
	"Batter_stat_rbi"	INTEGER NOT NULL,
	"Batter_stat_bb"	NUMERIC NOT NULL,
	"Batter_stat_so"	INTEGER NOT NULL,
	"Batter_state_po"	INTEGER,
	"Batter_stat_a"	INTEGER,
	"Batter_stat_lob"	INTEGER,
	"Batter_stat_hbp"	INTEGER NOT NULL,
	"Batter_stat_FB"	INTEGER NOT NULL DEFAULT 0,
	"Batter_stat_SB"	INTEGER NOT NULL DEFAULT 0,
	"Batter_stat_TB"	TEXT NOT NULL DEFAULT 0,
	"Batter_stat_hr"	INTEGER NOT NULL DEFAULT 0,
	"Batter_stat_total_bases"	INTEGER NOT NULL DEFAULT 0,
	FOREIGN KEY("Batter_stat_pos_id") REFERENCES "Positions"("Position_id"),
	FOREIGN KEY("Batter_stat_player_id") REFERENCES "Players"("Player_id"),
	FOREIGN KEY("Batter_stat_game_id") REFERENCES "Games"("Game_id"),
	FOREIGN KEY("Batter_stat_team_id") REFERENCES "Teams"("Team_id"),
	PRIMARY KEY("Batter_stat_id" AUTOINCREMENT)
);
INSERT INTO "TEST" ("PlayerID","PlayerName") VALUES (1,'Daniel Cronauer');
INSERT INTO "Teams" ("Team_id") VALUES ('Indiana'),
 ('Maryland'),
 ('Michigan'),
 ('Iowa'),
 ('Michigan State'),
 ('Rutgers'),
 ('Nebraska'),
 ('Purdue'),
 ('Illinois'),
 ('Penn State'),
 ('Minnesota'),
 ('Northwestern'),
 ('Ohio State'),
 ('Saint Joseph'),
 ('Georgia Tech'),
 ('Pittsburgh');
INSERT INTO "Positions" ("Position_id") VALUES ('1B'),
 ('2B'),
 ('3B'),
 ('C'),
 ('LF'),
 ('CF'),
 ('RF'),
 ('SS'),
 ('DH'),
 ('PH'),
 ('PR');
INSERT INTO "Games" ("Game_id","Game_team_one_id","Game_team_two_id","Game_win_id","Game_team_one_score","Game_team_two_score","Game_date") VALUES (1,'Saint Joseph','Ohio State','Saint Joseph',7,3,'2020-14-02');
INSERT INTO "Players" ("Player_id","Player_last_name","Player_first_name","Player_team_id") VALUES (1,'Karaffa','Nate','Ohio State'),
 (2,'Brookman','Archer','Ohio State'),
 (3,'Dingler','Dillon','Ohio State'),
 (4,'Todys','Brent','Ohio State'),
 (5,'Pohl','Conner','Ohio State'),
 (6,'Dezenzo','Zach','Ohio State'),
 (7,'Seymour','Scottie','Ohio State'),
 (8,'Clegg','Nolan','Ohio State'),
 (9,'Carpenter','Matt','Ohio State'),
 (10,'West','Noah','Ohio State'),
 (11,'Bauer','Colten','Ohio State'),
 (12,'Wilson','Sam','Ohio State'),
 (13,'Erwin','Nick','Ohio State'),
 (14,'Hughes','Aaron','Ohio State'),
 (15,'Ernst','Marcus','Ohio State'),
 (16,'Okuley','Mitchell','Ohio State'),
 (17,'Trigiani','Luca','Saint Joseph'),
 (18,'Hueth','Brendan','Saint Joseph'),
 (19,'Thomas','Nate','Saint Joseph'),
 (20,'Cossetti','Andrew','Saint Joseph'),
 (21,'McConnon','James','Saint Joseph'),
 (22,'Bendo','Liam','Saint Joseph'),
 (23,'Artz','Jake','Saint Joseph'),
 (24,'Livingston','Langston','Saint Joseph'),
 (25,'Zimmerman','Luke','Saint Joseph'),
 (26,'Markoski','Brian','Saint Joseph'),
 (27,'Namey','Kadar','Saint Joseph'),
 (28,'Waddell','L','Georgia Tech'),
 (29,'Hall','Co','Georgia Tech'),
 (30,'Guldberg','M','Georgia Tech'),
 (31,'Radcliff','B','Georgia Tech'),
 (32,'Compton','D','Georgia Tech'),
 (33,'Reid','S','Georgia Tech'),
 (34,'Gonzalez','T','Georgia Tech'),
 (35,'Webb','J','Georgia Tech'),
 (36,'Holland','J','Georgia Tech'),
 (37,'Wilhite','A','Georgia Tech'),
 (38,'Schaffer','Jordan','Indiana'),
 (39,'Cusumano','Dominic','Indiana'),
 (40,'Fuentes','Brian','Indiana'),
 (41,'Ross','Sean','Indiana'),
 (42,'Rivera','Miguel','Indiana'),
 (43,'Nowaskie','Brandt','Indiana'),
 (44,'Hanna II','Elison','Indiana'),
 (45,'Gines','Diego','Indiana'),
 (46,'Baker','Gavin','Indiana'),
 (47,'Garcia','Manny','Indiana'),
 (48,'Barrow','Mitch','Indiana'),
 (49,'Barrett','Nick','Indiana'),
 (50,'Magill','Grant','Indiana'),
 (51,'Kido','Joe','Indiana'),
 (52,'Harbison','Kyle','Indiana'),
 (53,'Test','Bobby','Michigan State'),
 (60,'Sue','Bobby','Michigan');
INSERT INTO "Batter_Stats" ("Batter_stat_id","Batter_stat_game_id","Batter_stat_team_id","Batter_stat_player_id","Batter_stat_pos_id","Batter_stat_ab","Batter_stat_runs","Batter_stat_hits","Batter_stat_rbi","Batter_stat_bb","Batter_stat_so","Batter_state_po","Batter_stat_a","Batter_stat_lob","Batter_stat_hbp","Batter_stat_FB","Batter_stat_SB","Batter_stat_TB","Batter_stat_hr","Batter_stat_total_bases") VALUES (1,'1','Ohio State',1,'CF',4,0,0,0,0,3,4,1,2,0,0,0,'0',0,0),
 (2,'1','Ohio State',2,'PH',1,0,0,0,0,1,0,0,0,0,0,0,'0',0,0),
 (3,'1','Ohio State',3,'C',3,1,1,2,0,0,10,1,0,1,0,0,'0',0,0),
 (4,'1','Ohio State',4,'DH',3,0,0,0,2,1,0,0,1,0,0,0,'0',0,0),
 (5,'1','Ohio State',5,'1B',4,0,0,0,0,2,4,0,1,0,0,0,'0',0,0),
 (6,'1','Ohio State',6,'3B',4,0,1,0,0,2,1,0,1,0,0,0,'0',0,0),
 (7,'1','Ohio State',7,'LF',3,0,1,1,0,0,0,0,0,1,0,0,'0',0,0),
 (8,'1','Ohio State',8,'RF',4,0,1,0,0,2,4,0,3,0,0,0,'0',0,0),
 (9,'1','Ohio State',9,'2B',4,0,0,0,0,2,3,1,1,0,0,0,'0',0,0),
 (10,'1','Ohio State',10,'SS',3,2,1,0,1,1,1,2,0,0,0,0,'0',0,0),
 (11,'1','Saint Joseph',17,'SS',4,1,0,0,1,2,0,3,0,0,0,0,'0',0,0),
 (12,'1','Saint Joseph',18,'CF',4,1,3,2,1,0,2,0,0,0,0,0,'0',0,0),
 (13,'1','Saint Joseph',19,'3B',5,0,1,0,0,2,1,0,0,0,0,0,'0',0,0),
 (14,'1','Saint Joseph',20,'DH',5,0,0,0,0,0,0,0,2,0,0,0,'0',0,0),
 (15,'1','Saint Joseph',21,'C',3,3,2,0,1,0,13,1,0,0,0,0,'0',0,0),
 (16,'1','Saint Joseph',22,'2B',4,0,0,0,0,3,3,2,0,0,0,0,'0',0,0),
 (17,'1','Saint Joseph',23,'RF',3,1,2,1,1,0,4,0,0,0,0,0,'0',0,0),
 (18,'1','Saint Joseph',24,'LF',3,1,1,3,0,1,0,0,0,0,0,0,'0',0,0),
 (19,'1','Saint Joseph',25,'1B',1,0,0,0,0,1,2,0,1,0,0,0,'0',0,0),
 (20,'1','Saint Joseph',26,'1B',3,0,0,0,0,2,2,0,3,0,0,0,'0',0,0),
 (21,'1','Saint Joseph',27,'LF',1,0,0,0,0,0,0,0,0,0,0,0,'0',0,0);
COMMIT;
