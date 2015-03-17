SELECT name, sql FROM sqlite_master WHERE type='table' ;
SELECT name, sql FROM sqlite_master WHERE type='index' 
CREATE TABLE programs (program_name TEXT, priority NUMERIC, clients TEXT);
SELECT name, sql FROM sqlite_master WHERE type='table' ;
PRAGMA TABLE_INFO(programs);
SELECT name, sql FROM sqlite_master WHERE type='index' 
SELECT rowid, *  FROM programs ORDER BY rowid; 
SELECT name, sql FROM sqlite_master WHERE type='table' ;
PRAGMA TABLE_INFO(programs);
SELECT name, sql FROM sqlite_master WHERE type='index' 
SELECT rowid, *  FROM programs ORDER BY rowid; 
SELECT name, sql FROM sqlite_master WHERE type='table' ;
PRAGMA TABLE_INFO(programs);
SELECT name, sql FROM sqlite_master WHERE type='index' 
SELECT rowid, *  FROM programs ORDER BY rowid; 
SELECT name, sql FROM sqlite_master WHERE type='table' ;
PRAGMA TABLE_INFO(programs);
SELECT name, sql FROM sqlite_master WHERE type='index' 
SELECT rowid, *  FROM programs ORDER BY rowid; 
SELECT name, sql FROM sqlite_master WHERE type='table' ;
PRAGMA TABLE_INFO(programs);
SELECT name, sql FROM sqlite_master WHERE type='index' 
SELECT rowid, *  FROM programs ORDER BY rowid; 
INSERT INTO programs VALUES(NULL, NULL, NULL);
SELECT rowid, *  FROM programs ORDER BY rowid; 
UPDATE programs SET program_name='The Program One' WHERE rowid=1;
UPDATE programs SET priority='111' WHERE rowid=1;
UPDATE programs SET clients='The Client One' WHERE rowid=1;
INSERT INTO programs VALUES(NULL, NULL, NULL);
SELECT rowid, *  FROM programs ORDER BY rowid; 
UPDATE programs SET program_name='The Program Two' WHERE rowid=2;
UPDATE programs SET priority='222' WHERE rowid=2;
UPDATE programs SET clients='The client two' WHERE rowid=2;
INSERT INTO programs VALUES(NULL, NULL, NULL);
SELECT rowid, *  FROM programs ORDER BY rowid; 
UPDATE programs SET program_name='The Program Three' WHERE rowid=3;
UPDATE programs SET priority='333' WHERE rowid=3;
UPDATE programs SET clients='The client three' WHERE rowid=3;
