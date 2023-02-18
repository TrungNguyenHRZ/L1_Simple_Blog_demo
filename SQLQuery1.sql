CREATE DATABASE SimpleBlog
GO
USE SimpleBlog
GO
CREATE TABLE tblAccounts (
	email		VARCHAR(50)		PRIMARY KEY,
	name		NVARCHAR(50)	NOT NULL,
	password	VARCHAR(50)		NOT NULL,
	role		VARCHAR(10)		NOT NULL,
	status		VARCHAR(30)		NOT NULL
)
GO
CREATE TABLE tblArticle(
	titleId				INT					IDENTITY(0,1)	PRIMARY KEY,
	titleName			NVARCHAR(50)		NOT NULL,
	shortDescription	NVARCHAR(100)		NOT NULL,
	content				NVARCHAR(MAX)		NOT NULL,		
	author				VARCHAR(50)			FOREIGN KEY REFERENCES tblAccounts(email),
	date				DATE				NOT NULL,
	status				VARCHAR(10)
)
GO
CREATE TABLE tblComment(
	commentId   INT				IDENTITY(0,1) PRIMARY KEY,
	titleId		INT				FOREIGN KEY REFERENCES tblArticle(titleId),
	email		VARCHAR(50)		FOREIGN KEY REFERENCES tblAccounts(email),
	comment		NVARCHAR(MAX)	
)
GO
INSERT INTO tblAccounts(email, name, password, role, status)
VALUES('user1@gmail.com','Trung','1','member','New')
INSERT INTO tblAccounts(email, name, password, role, status)
VALUES('admin1@gmail.com','Admin','1','admin','New')
INSERT INTO tblAccounts(email, name, password, role, status)
VALUES('user3@gmail.com','User3','1','member','New')
INSERT INTO tblAccounts(email, name, password, role, status)
VALUES('user2@gmail.com','User2','1','member','New')
GO

INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)
VALUES('AC1','AC1','AC1','user1@gmail.com','01/01/2000','Active')
INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)
VALUES('AC2','AC2','AC2','user2@gmail.com','02/02/2000','Active')
INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)
VALUES('AC3','AC3','AC3','user1@gmail.com','03/03/2000','Active')
INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)
VALUES('AC4','AC4','AC4','user3@gmail.com','04/04/2000','Active')
INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)
VALUES('AC5','AC5','AC5','user3@gmail.com','05/05/2000','Deleted')
INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)
VALUES('AC6','AC6','AC6','user2@gmail.com','06/06/2000','New')
GO
INSERT INTO tblComment(titleId, email, comment)
VALUES('0','user1@gmail.com','gogogogogogggogog')
INSERT INTO tblComment(titleId, email, comment)
VALUES('1','user2@gmail.com','hahahahaahahahaha')
INSERT INTO tblComment(titleId, email, comment)
VALUES('2','user1@gmail.com','OMGOMGOMGOMG')
GO