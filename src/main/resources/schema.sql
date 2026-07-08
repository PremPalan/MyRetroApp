-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Drop existing tables if they exist to prevent conflicts during re-runs
DROP TABLE IF EXISTS CARD CASCADE;
DROP TABLE IF EXISTS RETRO_BOARD CASCADE;

-- Create RETRO_BOARD table first so CARD can reference it
CREATE TABLE RETRO_BOARD (
                             ID   UUID DEFAULT uuid_generate_v4() NOT NULL,
                             NAME VARCHAR(255),
                             PRIMARY KEY (ID)
);

-- Create CARD table
CREATE TABLE CARD (
                      ID             UUID DEFAULT uuid_generate_v4() NOT NULL,
                      CARD_TYPE      VARCHAR(5),
                      COMMENT        VARCHAR(255),
                      RETRO_BOARD_ID UUID,
                      PRIMARY KEY (ID)
);

-- Add Foreign Key constraint linking CARD to RETRO_BOARD
ALTER TABLE CARD
    ADD CONSTRAINT FK_RETRO_BOARD_CARD
        FOREIGN KEY (RETRO_BOARD_ID) REFERENCES RETRO_BOARD(ID);