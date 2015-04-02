--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.4
-- Dumped by pg_dump version 9.0.4
-- Started on 2015-03-24 15:20:48

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1518 (class 1259 OID 21284)
-- Dependencies: 5
-- Name: menu2; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE menu2 (
    menu_id bigint NOT NULL,
    menu_code character varying(20),
    parent_code character varying(30),
    menu_name character varying(30),
    menu_url character varying(124),
    menu_type smallint,
    menu_level smallint,
    sequence smallint
);


ALTER TABLE public.menu2 OWNER TO postgres;

--
-- TOC entry 1801 (class 0 OID 21284)
-- Dependencies: 1518
-- Data for Name: menu2; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO menu2 (menu_id, menu_code, parent_code, menu_name, menu_url, menu_type, menu_level, sequence) VALUES (1, '000ADMIN', NULL, 'Menu Admin', NULL, NULL, 1, 0);
INSERT INTO menu2 (menu_id, menu_code, parent_code, menu_name, menu_url, menu_type, menu_level, sequence) VALUES (2, '001CUSTOMER', '000ADMIN', 'Customer', '/pages/master/customerList.jsf', NULL, 2, 1);
INSERT INTO menu2 (menu_id, menu_code, parent_code, menu_name, menu_url, menu_type, menu_level, sequence) VALUES (3, '002MENU', '000ADMIN', 'Menu', NULL, NULL, 2, 3);
INSERT INTO menu2 (menu_id, menu_code, parent_code, menu_name, menu_url, menu_type, menu_level, sequence) VALUES (4, '000MASTER', NULL, 'Menu Master', NULL, NULL, 1, 4);
INSERT INTO menu2 (menu_id, menu_code, parent_code, menu_name, menu_url, menu_type, menu_level, sequence) VALUES (5, '000EMPLOYEE', '000MASTER', 'Employee', '/pages/master/employee.jsf', NULL, 2, 5);
INSERT INTO menu2 (menu_id, menu_code, parent_code, menu_name, menu_url, menu_type, menu_level, sequence) VALUES (6, '010CUSTINPUT', '002MENU', 'Customer Input', '/pages/master/customerInput.jsf', NULL, 3, 6);


--
-- TOC entry 1800 (class 2606 OID 21288)
-- Dependencies: 1518 1518
-- Name: menu2_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY menu2
    ADD CONSTRAINT menu2_pkey PRIMARY KEY (menu_id);


-- Completed on 2015-03-24 15:20:49

--
-- PostgreSQL database dump complete
--

