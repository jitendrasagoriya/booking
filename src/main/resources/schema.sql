
CREATE TABLE  users (
  ID INTEGER IDENTITY PRIMARY KEY ,
  NAME VARCHAR(50)  ,
  EMAIL VARCHAR(50)  ,
  PASSWORD VARCHAR(50)  ,
  REG_DT VARCHAR(50)  ,
  LST_LOGIN TIMESTAMP ,
  IS_REG INTEGER    
) ;