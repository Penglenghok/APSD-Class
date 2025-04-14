/*
 Navicat Premium Data Transfer

 Source Server         : mac-local
 Source Server Type    : PostgreSQL
 Source Server Version : 140002 (140002)
 Source Host           : localhost:5432
 Source Catalog        : APSAMidterm
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140002 (140002)
 File Encoding         : 65001

 Date: 08/04/2025 11:03:52
*/


-- ----------------------------
-- Table structure for Account
-- ----------------------------
DROP TABLE IF EXISTS "public"."Account";
CREATE TABLE "public"."Account" (
  "accountId" int4 NOT NULL,
  "accountNumber" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "dateOpened" date NOT NULL,
  "status" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "balance" numeric(10,2) NOT NULL,
  "accountTypeId" int4 NOT NULL
)
;
ALTER TABLE "public"."Account" OWNER TO "postgres";

-- ----------------------------
-- Records of Account
-- ----------------------------
BEGIN;
INSERT INTO "public"."Account" ("accountId", "accountNumber", "dateOpened", "status", "balance", "accountTypeId") VALUES (1, 'CK1089', '2021-10-15', 'Active', 105945.50, 2);
INSERT INTO "public"."Account" ("accountId", "accountNumber", "dateOpened", "status", "balance", "accountTypeId") VALUES (2, 'SV1104', '2019-06-22', 'Active', 197750.00, 1);
INSERT INTO "public"."Account" ("accountId", "accountNumber", "dateOpened", "status", "balance", "accountTypeId") VALUES (3, 'SV2307', '2014-02-27', 'Dormant', 842000.75, 1);
INSERT INTO "public"."Account" ("accountId", "accountNumber", "dateOpened", "status", "balance", "accountTypeId") VALUES (4, 'LN4133', '2005-11-07', 'Active', 674500.00, 3);
COMMIT;

-- ----------------------------
-- Table structure for AccountType
-- ----------------------------
DROP TABLE IF EXISTS "public"."AccountType";
CREATE TABLE "public"."AccountType" (
  "accountTypeId" int4 NOT NULL,
  "accountTypeName" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "public"."AccountType" OWNER TO "postgres";

-- ----------------------------
-- Records of AccountType
-- ----------------------------
BEGIN;
INSERT INTO "public"."AccountType" ("accountTypeId", "accountTypeName") VALUES (1, 'Checking');
INSERT INTO "public"."AccountType" ("accountTypeId", "accountTypeName") VALUES (2, 'Savings');
INSERT INTO "public"."AccountType" ("accountTypeId", "accountTypeName") VALUES (3, 'Loan');
COMMIT;

-- ----------------------------
-- Table structure for Customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."Customer";
CREATE TABLE "public"."Customer" (
  "customerId" int4 NOT NULL,
  "firstName" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "lastName" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "telephoneNumber" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."Customer" OWNER TO "postgres";

-- ----------------------------
-- Records of Customer
-- ----------------------------
BEGIN;
INSERT INTO "public"."Customer" ("customerId", "firstName", "lastName", "telephoneNumber") VALUES (1, 'Daniel', 'Agar', NULL);
INSERT INTO "public"."Customer" ("customerId", "firstName", "lastName", "telephoneNumber") VALUES (3, 'Carly', 'Carly', NULL);
INSERT INTO "public"."Customer" ("customerId", "firstName", "lastName", "telephoneNumber") VALUES (2, 'Bernard', 'Shaw', '(641) 472-1234 ');
COMMIT;

-- ----------------------------
-- Table structure for Transaction
-- ----------------------------
DROP TABLE IF EXISTS "public"."Transaction";
CREATE TABLE "public"."Transaction" (
  "transactionId" int4 NOT NULL,
  "transactionNumber" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "valueAmount" numeric(10,2) NOT NULL,
  "transactionDate" date NOT NULL,
  "transactionTime" time(6) NOT NULL,
  "transactionType" varchar(255) COLLATE "pg_catalog"."default",
  "accountId" int4
)
;
ALTER TABLE "public"."Transaction" OWNER TO "postgres";

-- ----------------------------
-- Records of Transaction
-- ----------------------------
BEGIN;
INSERT INTO "public"."Transaction" ("transactionId", "transactionNumber", "description", "valueAmount", "transactionDate", "transactionTime", "transactionType", "accountId") VALUES (1, 'D0187-175', 'Deposit to Savings ', 100000.00, '2021-10-15', '12:15:00', 'Deposit', 2);
INSERT INTO "public"."Transaction" ("transactionId", "transactionNumber", "description", "valueAmount", "transactionDate", "transactionTime", "transactionType", "accountId") VALUES (2, 'W1736-142 ', 'Teller counter
withdrawal ', 550.00, '2022-08-24', '10:05:00', 'Withdrawal', 1);
INSERT INTO "public"."Transaction" ("transactionId", "transactionNumber", "description", "valueAmount", "transactionDate", "transactionTime", "transactionType", "accountId") VALUES (3, 'DD001-142 ', 'Direct deposit – wage', 2475.75, '2014-03-01', '05:00:00', 'Direct deposit', 1);
INSERT INTO "public"."Transaction" ("transactionId", "transactionNumber", "description", "valueAmount", "transactionDate", "transactionTime", "transactionType", "accountId") VALUES (4, 'P162-0017', 'Merch purchase
online', 150.95, '2019-12-15', '14:19:00', 'Purchase', 1);
COMMIT;

-- ----------------------------
-- Table structure for customerAccount
-- ----------------------------
DROP TABLE IF EXISTS "public"."customerAccount";
CREATE TABLE "public"."customerAccount" (
  "customerAccountId" int4 NOT NULL,
  "customerId" int4 NOT NULL,
  "accountId" int4 NOT NULL
)
;
ALTER TABLE "public"."customerAccount" OWNER TO "postgres";

-- ----------------------------
-- Records of customerAccount
-- ----------------------------
BEGIN;
INSERT INTO "public"."customerAccount" ("customerAccountId", "customerId", "accountId") VALUES (1, 3, 1);
INSERT INTO "public"."customerAccount" ("customerAccountId", "customerId", "accountId") VALUES (2, 1, 2);
INSERT INTO "public"."customerAccount" ("customerAccountId", "customerId", "accountId") VALUES (3, 2, 2);
INSERT INTO "public"."customerAccount" ("customerAccountId", "customerId", "accountId") VALUES (4, 3, 3);
INSERT INTO "public"."customerAccount" ("customerAccountId", "customerId", "accountId") VALUES (5, 3, 4);
COMMIT;

-- ----------------------------
-- Primary Key structure for table Account
-- ----------------------------
ALTER TABLE "public"."Account" ADD CONSTRAINT "Account_pkey" PRIMARY KEY ("accountId");

-- ----------------------------
-- Primary Key structure for table AccountType
-- ----------------------------
ALTER TABLE "public"."AccountType" ADD CONSTRAINT "AccountType_pkey" PRIMARY KEY ("accountTypeId");

-- ----------------------------
-- Primary Key structure for table Customer
-- ----------------------------
ALTER TABLE "public"."Customer" ADD CONSTRAINT "Customer_pkey" PRIMARY KEY ("customerId");

-- ----------------------------
-- Primary Key structure for table Transaction
-- ----------------------------
ALTER TABLE "public"."Transaction" ADD CONSTRAINT "Transaction_pkey" PRIMARY KEY ("transactionId");

-- ----------------------------
-- Primary Key structure for table customerAccount
-- ----------------------------
ALTER TABLE "public"."customerAccount" ADD CONSTRAINT "customerAccount_pkey" PRIMARY KEY ("customerAccountId");

-- ----------------------------
-- Foreign Keys structure for table Account
-- ----------------------------
ALTER TABLE "public"."Account" ADD CONSTRAINT "accountType" FOREIGN KEY ("accountTypeId") REFERENCES "public"."AccountType" ("accountTypeId") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Transaction
-- ----------------------------
ALTER TABLE "public"."Transaction" ADD CONSTRAINT "accountId" FOREIGN KEY ("accountId") REFERENCES "public"."Account" ("accountId") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table customerAccount
-- ----------------------------
ALTER TABLE "public"."customerAccount" ADD CONSTRAINT "account" FOREIGN KEY ("accountId") REFERENCES "public"."Account" ("accountId") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."customerAccount" ADD CONSTRAINT "customer" FOREIGN KEY ("customerId") REFERENCES "public"."Customer" ("customerId") ON DELETE NO ACTION ON UPDATE NO ACTION;




-- ******** Customer Query for task 5 ********

-- Select all account
SELECT * from "Account" a join "customerAccount" ca on a."accountId" = ca."accountId" join "Customer" c on ca."customerId"=c."customerId" ORDER BY a.balance DESC;

-- select all transaction
SELECT * from "Transaction" t join "Account" a on t."accountId" = a."accountId" WHERE t."valueAmount" > 500 ORDER BY t."transactionDate" ASC , t."transactionTime" ASC;
