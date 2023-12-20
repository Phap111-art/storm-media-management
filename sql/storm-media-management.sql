/*
 Navicat Premium Data Transfer

 Source Server         : My-DB
 Source Server Type    : PostgreSQL
 Source Server Version : 110021
 Source Host           : localhost:5432
 Source Catalog        : storm-media-management
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110021
 File Encoding         : 65001

 Date: 20/12/2023 16:38:39
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
INSERT INTO "public"."storms" VALUES ('4703c650-369c-493e-bfad-167214cacae4', 1, 'da nang', '2023-12-20 16:17:53.378887');
INSERT INTO "public"."storms" VALUES ('ca6a917e-5e59-4fa8-a241-dbd42a833147', 2, 'hue', '2023-12-20 16:17:53.380888');
INSERT INTO "public"."storms" VALUES ('aa3dfd2f-a6d8-440e-9f76-385fcd0e1eef', 2, 'quy nhon', '2023-12-20 16:17:53.381886');
INSERT INTO "public"."storms" VALUES ('4ec9245a-284e-4613-b677-90f9ad5fd273', 2, 'hanoi', '2023-12-20 16:17:53.381886');
INSERT INTO "public"."storms" VALUES ('d02a305e-629a-490b-9a0a-5933094e0427', 2, 'saigon', '2023-12-20 16:17:53.381886');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "user_id" uuid NOT NULL,
  "created_at" timestamp(6),
  "password" varchar(20) COLLATE "pg_catalog"."default",
  "updated_at" timestamp(6),
  "username" varchar(20) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES ('0ac99942-2a8e-48e5-b20f-7d8043251b0e', '2023-12-20 15:46:24.159904', '123', NULL, 'thongnguyen');

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
