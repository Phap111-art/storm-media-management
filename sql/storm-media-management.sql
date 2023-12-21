/*
 Navicat Premium Data Transfer

 Source Server         : PG15
 Source Server Type    : PostgreSQL
 Source Server Version : 120017
 Source Host           : localhost:5432
 Source Catalog        : storm-media-management
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120017
 File Encoding         : 65001

 Date: 21/12/2023 10:08:24
*/


-- ----------------------------
-- Sequence structure for attachments_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."attachments_seq";
CREATE SEQUENCE "public"."attachments_seq" 
INCREMENT 50
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for attachments
-- ----------------------------
DROP TABLE IF EXISTS "public"."attachments";
CREATE TABLE "public"."attachments" (
  "attachment_id" int8 NOT NULL,
  "attachment_path" varchar(255) COLLATE "pg_catalog"."default",
  "attachment_type" varchar(255) COLLATE "pg_catalog"."default",
  "comment_id" uuid
)
;

-- ----------------------------
-- Records of attachments
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS "public"."comments";
CREATE TABLE "public"."comments" (
  "comment_id" uuid NOT NULL,
  "comment_text" varchar(255) COLLATE "pg_catalog"."default",
  "storm_id" uuid,
  "user_user_id" uuid
)
;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for storms
-- ----------------------------
DROP TABLE IF EXISTS "public"."storms";
CREATE TABLE "public"."storms" (
  "storm_id" uuid NOT NULL,
  "affected_areas" int4 NOT NULL,
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "detected_time" timestamp(6)
)
;

-- ----------------------------
-- Records of storms
-- ----------------------------
INSERT INTO "public"."storms" VALUES ('8b092057-f41d-4aa0-be76-49815ba3c6e4', 1, 'da nang', '2023-12-21 10:04:32.910866');
INSERT INTO "public"."storms" VALUES ('b11b7b30-db85-41fb-b0ef-6fd67860c30b', 2, 'hue', '2023-12-21 10:04:32.914861');
INSERT INTO "public"."storms" VALUES ('3ddcf7cb-9235-40de-8ece-c014e7dcb555', 2, 'quy nhon', '2023-12-21 10:04:32.914861');
INSERT INTO "public"."storms" VALUES ('a874632e-e1d3-4464-9465-42a112bcf1ae', 2, 'hanoi', '2023-12-21 10:04:32.914861');
INSERT INTO "public"."storms" VALUES ('c58378e0-8142-41b2-8aa1-28dd0ba1dd4f', 2, 'saigon', '2023-12-21 10:04:32.915862');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "user_id" uuid NOT NULL,
  "created_at" timestamp(6),
  "password" varchar(250) COLLATE "pg_catalog"."default",
  "updated_at" timestamp(6),
  "username" varchar(20) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES ('0ac99942-2a8e-48e5-b20f-7d8043251b0e', '2023-12-20 15:46:24.159904', '123', NULL, 'thongnguyen');
INSERT INTO "public"."users" VALUES ('a9dc819e-7f02-49a4-8f93-20bd5a5ef7e2', '2023-12-21 10:06:12.136155', 'lRy2c5x6epk/6fHRVAT+u+pqVxfOGpR2vdWiRE7nPfw=', NULL, 'tuan');

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."attachments_seq"', 1, false);

-- ----------------------------
-- Primary Key structure for table attachments
-- ----------------------------
ALTER TABLE "public"."attachments" ADD CONSTRAINT "attachments_pkey" PRIMARY KEY ("attachment_id");

-- ----------------------------
-- Primary Key structure for table comments
-- ----------------------------
ALTER TABLE "public"."comments" ADD CONSTRAINT "comments_pkey" PRIMARY KEY ("comment_id");

-- ----------------------------
-- Primary Key structure for table storms
-- ----------------------------
ALTER TABLE "public"."storms" ADD CONSTRAINT "storms_pkey" PRIMARY KEY ("storm_id");

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Foreign Keys structure for table attachments
-- ----------------------------
ALTER TABLE "public"."attachments" ADD CONSTRAINT "fkbydtpaj4hcd1ahpdu9091hlpp" FOREIGN KEY ("comment_id") REFERENCES "public"."comments" ("comment_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table comments
-- ----------------------------
ALTER TABLE "public"."comments" ADD CONSTRAINT "fkcc96r34gkial9e3fxphcr3abt" FOREIGN KEY ("user_user_id") REFERENCES "public"."users" ("user_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."comments" ADD CONSTRAINT "fkj2qm981r5aix39yr2r8hsvg5i" FOREIGN KEY ("storm_id") REFERENCES "public"."storms" ("storm_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
