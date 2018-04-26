--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.8
-- Dumped by pg_dump version 9.6.8

-- Started on 2018-04-16 14:50:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2269 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 206 (class 1259 OID 17692)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    contenue character varying NOT NULL,
    date_parution date NOT NULL,
    utilisateur_id integer NOT NULL,
    topo_id integer,
    spot_id integer
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17690)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 2270 (class 0 OID 0)
-- Dependencies: 205
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- TOC entry 188 (class 1259 OID 17611)
-- Name: cotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cotation (
    id integer NOT NULL,
    cotation character varying(2) NOT NULL
);


ALTER TABLE public.cotation OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 17609)
-- Name: cotation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cotation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cotation_id_seq OWNER TO postgres;

--
-- TOC entry 2271 (class 0 OID 0)
-- Dependencies: 187
-- Name: cotation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cotation_id_seq OWNED BY public.cotation.id;


--
-- TOC entry 186 (class 1259 OID 17603)
-- Name: orientation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orientation (
    id integer NOT NULL,
    orientation character varying(10) NOT NULL
);


ALTER TABLE public.orientation OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 17601)
-- Name: orientation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orientation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orientation_id_seq OWNER TO postgres;

--
-- TOC entry 2272 (class 0 OID 0)
-- Dependencies: 185
-- Name: orientation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orientation_id_seq OWNED BY public.orientation.id;


--
-- TOC entry 190 (class 1259 OID 17619)
-- Name: pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    code_pays character varying(2) NOT NULL
);


ALTER TABLE public.pays OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 17617)
-- Name: pays_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pays_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pays_id_seq OWNER TO postgres;

--
-- TOC entry 2273 (class 0 OID 0)
-- Dependencies: 189
-- Name: pays_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pays_id_seq OWNED BY public.pays.id;


--
-- TOC entry 208 (class 1259 OID 17703)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id integer NOT NULL,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    topo_id integer NOT NULL,
    utilisateur_id integer NOT NULL
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17701)
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_id_seq OWNER TO postgres;

--
-- TOC entry 2274 (class 0 OID 0)
-- Dependencies: 207
-- Name: reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;


--
-- TOC entry 202 (class 1259 OID 17673)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id integer NOT NULL,
    role character varying(100) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17671)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 2275 (class 0 OID 0)
-- Dependencies: 201
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 198 (class 1259 OID 17657)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    site_id integer NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 17655)
-- Name: secteur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_id_seq OWNER TO postgres;

--
-- TOC entry 2276 (class 0 OID 0)
-- Dependencies: 197
-- Name: secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;


--
-- TOC entry 194 (class 1259 OID 17635)
-- Name: spot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spot (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    description character varying(300) NOT NULL,
    photo character varying(255) NOT NULL,
    pays_id integer NOT NULL,
    ville_id integer NOT NULL
);


ALTER TABLE public.spot OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 17633)
-- Name: spot_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.spot_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spot_id_seq OWNER TO postgres;

--
-- TOC entry 2277 (class 0 OID 0)
-- Dependencies: 193
-- Name: spot_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.spot_id_seq OWNED BY public.spot.id;


--
-- TOC entry 196 (class 1259 OID 17646)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    description character varying(300) NOT NULL,
    photo character varying(255) NOT NULL,
    prive boolean NOT NULL,
    reserve boolean NOT NULL,
    spot_id integer NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 17644)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_seq OWNER TO postgres;

--
-- TOC entry 2278 (class 0 OID 0)
-- Dependencies: 195
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;


--
-- TOC entry 204 (class 1259 OID 17681)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    prenom character varying(100) NOT NULL,
    pseudo character varying(100) NOT NULL,
    mail character varying(255) NOT NULL,
    password character varying(150) NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17679)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO postgres;

--
-- TOC entry 2279 (class 0 OID 0)
-- Dependencies: 203
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;


--
-- TOC entry 192 (class 1259 OID 17627)
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    code_postal integer NOT NULL,
    pays_id integer NOT NULL
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 17625)
-- Name: ville_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ville_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ville_id_seq OWNER TO postgres;

--
-- TOC entry 2280 (class 0 OID 0)
-- Dependencies: 191
-- Name: ville_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ville_id_seq OWNED BY public.ville.id;


--
-- TOC entry 200 (class 1259 OID 17665)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    nb_longueur integer NOT NULL,
    cotation_id integer NOT NULL,
    orientation_id integer NOT NULL,
    secteur_id integer NOT NULL
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 17663)
-- Name: voie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_seq OWNER TO postgres;

--
-- TOC entry 2281 (class 0 OID 0)
-- Dependencies: 199
-- Name: voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;


--
-- TOC entry 2081 (class 2604 OID 17695)
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 2072 (class 2604 OID 17614)
-- Name: cotation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation ALTER COLUMN id SET DEFAULT nextval('public.cotation_id_seq'::regclass);


--
-- TOC entry 2071 (class 2604 OID 17606)
-- Name: orientation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orientation ALTER COLUMN id SET DEFAULT nextval('public.orientation_id_seq'::regclass);


--
-- TOC entry 2073 (class 2604 OID 17622)
-- Name: pays id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays ALTER COLUMN id SET DEFAULT nextval('public.pays_id_seq'::regclass);


--
-- TOC entry 2082 (class 2604 OID 17706)
-- Name: reservation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id SET DEFAULT nextval('public.reservation_id_seq'::regclass);


--
-- TOC entry 2079 (class 2604 OID 17676)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 2077 (class 2604 OID 17660)
-- Name: secteur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN id SET DEFAULT nextval('public.secteur_id_seq'::regclass);


--
-- TOC entry 2075 (class 2604 OID 17638)
-- Name: spot id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot ALTER COLUMN id SET DEFAULT nextval('public.spot_id_seq'::regclass);


--
-- TOC entry 2076 (class 2604 OID 17649)
-- Name: topo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 2080 (class 2604 OID 17684)
-- Name: utilisateur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 2074 (class 2604 OID 17630)
-- Name: ville id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville ALTER COLUMN id SET DEFAULT nextval('public.ville_id_seq'::regclass);


--
-- TOC entry 2078 (class 2604 OID 17668)
-- Name: voie id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN id SET DEFAULT nextval('public.voie_id_seq'::regclass);


--
-- TOC entry 2259 (class 0 OID 17692)
-- Dependencies: 206
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, contenue, date_parution, utilisateur_id, topo_id, spot_id) FROM stdin;
1	C'est pas vraiment un super site	2018-03-04	2	1	2
2	Super topo idéal pour apprendre le terrain	2018-03-12	1	2	1
3	Le topo n'est pas bien rédigé	2018-03-18	2	4	1
4	Le site est vraiment l'idéal pour les débutants	2018-04-06	1	1	4
\.


--
-- TOC entry 2282 (class 0 OID 0)
-- Dependencies: 205
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 4, true);


--
-- TOC entry 2241 (class 0 OID 17611)
-- Dependencies: 188
-- Data for Name: cotation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cotation (id, cotation) FROM stdin;
1	3A
2	3B
3	3C
4	4A
5	4B
6	4C
7	5A
8	5B
9	5C
10	6A
11	6B
12	6C
13	7A
14	7B
15	7C
16	8A
17	8B
18	8C
19	9A
20	9B
21	9C
\.


--
-- TOC entry 2283 (class 0 OID 0)
-- Dependencies: 187
-- Name: cotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cotation_id_seq', 21, true);


--
-- TOC entry 2239 (class 0 OID 17603)
-- Dependencies: 186
-- Data for Name: orientation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orientation (id, orientation) FROM stdin;
1	Nord
2	Sud
3	Est
4	Ouest
\.


--
-- TOC entry 2284 (class 0 OID 0)
-- Dependencies: 185
-- Name: orientation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orientation_id_seq', 4, true);


--
-- TOC entry 2243 (class 0 OID 17619)
-- Dependencies: 190
-- Data for Name: pays; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pays (id, nom, code_pays) FROM stdin;
1	Choisir pays	cp
2	France	FR
3	Angleterre	EN
4	Italie	IT
5	Afrique du Sud	ZA
\.


--
-- TOC entry 2285 (class 0 OID 0)
-- Dependencies: 189
-- Name: pays_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pays_id_seq', 5, true);


--
-- TOC entry 2261 (class 0 OID 17703)
-- Dependencies: 208
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id, date_debut, date_fin, topo_id, utilisateur_id) FROM stdin;
1	2018-02-03	2018-02-06	2	1
2	2018-03-17	2018-03-29	4	2
3	2018-03-22	2018-04-01	2	2
4	2018-04-04	2018-05-05	4	1
\.


--
-- TOC entry 2286 (class 0 OID 0)
-- Dependencies: 207
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 4, true);


--
-- TOC entry 2255 (class 0 OID 17673)
-- Dependencies: 202
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, role) FROM stdin;
1	user
2	admin
\.


--
-- TOC entry 2287 (class 0 OID 0)
-- Dependencies: 201
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 2, true);


--
-- TOC entry 2251 (class 0 OID 17657)
-- Dependencies: 198
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secteur (id, nom, site_id) FROM stdin;
2	Le coeur	3
1	Le cerveau	2
4	The liver	5
3	Il stomaco	4
\.


--
-- TOC entry 2288 (class 0 OID 0)
-- Dependencies: 197
-- Name: secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_id_seq', 4, true);


--
-- TOC entry 2247 (class 0 OID 17635)
-- Dependencies: 194
-- Data for Name: spot; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spot (id, nom, description, photo, pays_id, ville_id) FROM stdin;
1	non spot	ceci n'est pas un spot	non_spot.jpg	1	1
2	Fontainebleau	Le site de Fontainebleau est bien pour les débutants	fontainebleau.jpg	2	2
3	Verdon	Le site par excellence pour les grimpeurs chevronné	verdon.jpg	2	3
4	Cala Ganone	Le site idéal pour grimpeur de tout niveau	cala_ganone.jpg	4	4
5	Capetown	Le site des professionnels de la grimpette	capetown.jpg	5	5
\.


--
-- TOC entry 2289 (class 0 OID 0)
-- Dependencies: 193
-- Name: spot_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.spot_id_seq', 5, true);


--
-- TOC entry 2249 (class 0 OID 17646)
-- Dependencies: 196
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, nom, description, photo, prive, reserve, spot_id) FROM stdin;
1	Choisir topo	ceci n'est pas un topo	non_topo.jpg	t	t	1
2	topo_verdon	C'est le topo pour ceux qui veulent découvrir le verdon	topo_verdon.jpg	t	f	3
3	topo_ayers	c'est le topo pour ceux qui veulent gravir le Ayers Rock en Australie	topo_ayers.jpg	f	f	1
4	topo_capetown	topo pour les expert de l'Afrique du Sud	topo_capetown.jpg	t	t	5
\.


--
-- TOC entry 2290 (class 0 OID 0)
-- Dependencies: 195
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 4, true);


--
-- TOC entry 2257 (class 0 OID 17681)
-- Dependencies: 204
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, nom, prenom, pseudo, mail, password, role_id) FROM stdin;
1	Diris	Vianney	vianney	vianney.diris@gmail.com	azertyuiop	2
2	Brelet	Dominique	dominique	dominique.brelet@gmail.com	matheo59	1
\.


--
-- TOC entry 2291 (class 0 OID 0)
-- Dependencies: 203
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 2, true);


--
-- TOC entry 2245 (class 0 OID 17627)
-- Dependencies: 192
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ville (id, nom, code_postal, pays_id) FROM stdin;
1	Choisir ville	0	1
2	Fontainebleau	77920	2
3	Le Verdon	33123	2
4	Sardaigne	104017	4
5	Capetown	7103	5
\.


--
-- TOC entry 2292 (class 0 OID 0)
-- Dependencies: 191
-- Name: ville_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ville_id_seq', 6, true);


--
-- TOC entry 2253 (class 0 OID 17665)
-- Dependencies: 200
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (id, nom, nb_longueur, cotation_id, orientation_id, secteur_id) FROM stdin;
1	la voie des anges	12	8	1	1
2	les pionniers	31	15	2	2
3	le voyage des chandeliers	15	11	2	2
4	la via de Michelangelo	22	17	3	3
5	la descente de Dante	31	20	4	4
\.


--
-- TOC entry 2293 (class 0 OID 0)
-- Dependencies: 199
-- Name: voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_id_seq', 6, true);


--
-- TOC entry 2104 (class 2606 OID 17700)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id);


--
-- TOC entry 2086 (class 2606 OID 17616)
-- Name: cotation cotation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation
    ADD CONSTRAINT cotation_pk PRIMARY KEY (id);


--
-- TOC entry 2084 (class 2606 OID 17608)
-- Name: orientation orientation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orientation
    ADD CONSTRAINT orientation_pk PRIMARY KEY (id);


--
-- TOC entry 2088 (class 2606 OID 17624)
-- Name: pays pays_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays
    ADD CONSTRAINT pays_pk PRIMARY KEY (id);


--
-- TOC entry 2106 (class 2606 OID 17708)
-- Name: reservation reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pk PRIMARY KEY (id);


--
-- TOC entry 2100 (class 2606 OID 17678)
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- TOC entry 2096 (class 2606 OID 17662)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (id);


--
-- TOC entry 2092 (class 2606 OID 17643)
-- Name: spot spot_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pk PRIMARY KEY (id);


--
-- TOC entry 2094 (class 2606 OID 17654)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id);


--
-- TOC entry 2102 (class 2606 OID 17689)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id);


--
-- TOC entry 2090 (class 2606 OID 17632)
-- Name: ville ville_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT ville_pk PRIMARY KEY (id);


--
-- TOC entry 2098 (class 2606 OID 17670)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (id);


--
-- TOC entry 2113 (class 2606 OID 17714)
-- Name: voie cotation_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT cotation_voie_fk FOREIGN KEY (cotation_id) REFERENCES public.cotation(id);


--
-- TOC entry 2112 (class 2606 OID 17709)
-- Name: voie orientation_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT orientation_voie_fk FOREIGN KEY (orientation_id) REFERENCES public.orientation(id);


--
-- TOC entry 2108 (class 2606 OID 17724)
-- Name: spot pays_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT pays_spot_fk FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 2107 (class 2606 OID 17719)
-- Name: ville pays_ville_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT pays_ville_fk FOREIGN KEY (pays_id) REFERENCES public.pays(id);


--
-- TOC entry 2115 (class 2606 OID 17764)
-- Name: utilisateur role_utilisateur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT role_utilisateur_fk FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2114 (class 2606 OID 17759)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (secteur_id) REFERENCES public.secteur(id);


--
-- TOC entry 2116 (class 2606 OID 17739)
-- Name: commentaire spot_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT spot_commentaire_fk FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 2111 (class 2606 OID 17734)
-- Name: secteur spot_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT spot_secteur_fk FOREIGN KEY (site_id) REFERENCES public.spot(id);


--
-- TOC entry 2110 (class 2606 OID 17744)
-- Name: topo spot_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT spot_topo_fk FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 2117 (class 2606 OID 17754)
-- Name: commentaire topo_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT topo_commentaire_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 2119 (class 2606 OID 17749)
-- Name: reservation topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT topo_reservation_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 2118 (class 2606 OID 17774)
-- Name: commentaire utilisateur_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT utilisateur_commentaire_fk FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 2120 (class 2606 OID 17769)
-- Name: reservation utilisateur_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT utilisateur_reservation_fk FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 2109 (class 2606 OID 17729)
-- Name: spot ville_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT ville_spot_fk FOREIGN KEY (ville_id) REFERENCES public.ville(id);


-- Completed on 2018-04-16 14:50:52

--
-- PostgreSQL database dump complete
--

