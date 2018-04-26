
CREATE SEQUENCE public.orientation_id_seq;

CREATE TABLE public.orientation (
                id INTEGER NOT NULL DEFAULT nextval('public.orientation_id_seq'),
                orientation VARCHAR(10) NOT NULL,
                CONSTRAINT orientation_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.orientation_id_seq OWNED BY public.orientation.id;

CREATE SEQUENCE public.cotation_id_seq;

CREATE TABLE public.cotation (
                id INTEGER NOT NULL DEFAULT nextval('public.cotation_id_seq'),
                cotation VARCHAR(2) NOT NULL,
                CONSTRAINT cotation_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.cotation_id_seq OWNED BY public.cotation.id;

CREATE SEQUENCE public.pays_id_seq;

CREATE TABLE public.pays (
                id INTEGER NOT NULL DEFAULT nextval('public.pays_id_seq'),
                nom VARCHAR(100) NOT NULL,
                code_pays VARCHAR(2) NOT NULL,
                CONSTRAINT pays_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.pays_id_seq OWNED BY public.pays.id;

CREATE SEQUENCE public.ville_id_seq;

CREATE TABLE public.ville (
                id INTEGER NOT NULL DEFAULT nextval('public.ville_id_seq'),
                nom VARCHAR(100) NOT NULL,
                code_postal INTEGER NOT NULL,
                pays_id INTEGER NOT NULL,
                CONSTRAINT ville_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.ville_id_seq OWNED BY public.ville.id;

CREATE SEQUENCE public.spot_id_seq;

CREATE TABLE public.spot (
                id INTEGER NOT NULL DEFAULT nextval('public.spot_id_seq'),
                nom VARCHAR(100) NOT NULL,
                description VARCHAR(300) NOT NULL,
                photo VARCHAR(255) NOT NULL,
                pays_id INTEGER NOT NULL,
                ville_id INTEGER NOT NULL,
                CONSTRAINT spot_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.spot_id_seq OWNED BY public.spot.id;

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
                nom VARCHAR(100) NOT NULL,
                description VARCHAR(300) NOT NULL,
                photo VARCHAR(255) NOT NULL,
                prive BOOLEAN NOT NULL,
                reserve BOOLEAN NOT NULL,
                spot_id INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;

CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                nom VARCHAR(100) NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                nom VARCHAR(100) NOT NULL,
                nb_longueur INTEGER NOT NULL,
                cotation_id INTEGER NOT NULL,
                orientation_id INTEGER NOT NULL,
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;

CREATE SEQUENCE public.role_id_seq;

CREATE TABLE public.role (
                id INTEGER NOT NULL DEFAULT nextval('public.role_id_seq'),
                role VARCHAR(100) NOT NULL,
                CONSTRAINT role_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;

CREATE SEQUENCE public.utilisateur_id_seq;

CREATE TABLE public.utilisateur (
                id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_seq'),
                nom VARCHAR(100) NOT NULL,
                prenom VARCHAR(100) NOT NULL,
                pseudo VARCHAR(100) NOT NULL,
                mail VARCHAR(255) NOT NULL,
                password VARCHAR(150) NOT NULL,
                role_id INTEGER NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;

CREATE SEQUENCE public.commentaire_id_seq;

CREATE TABLE public.commentaire (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_id_seq'),
                contenue VARCHAR NOT NULL,
                date_parution DATE NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                topo_id INTEGER,
                spot_id INTEGER,
                CONSTRAINT commentaire_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;

CREATE SEQUENCE public.reservation_id_seq;

CREATE TABLE public.reservation (
                id INTEGER NOT NULL DEFAULT nextval('public.reservation_id_seq'),
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                topo_id INTEGER NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT reservation_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;

ALTER TABLE public.voie ADD CONSTRAINT orientation_voie_fk
FOREIGN KEY (orientation_id)
REFERENCES public.orientation (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT cotation_voie_fk
FOREIGN KEY (cotation_id)
REFERENCES public.cotation (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ville ADD CONSTRAINT pays_ville_fk
FOREIGN KEY (pays_id)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot ADD CONSTRAINT pays_spot_fk
FOREIGN KEY (pays_id)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot ADD CONSTRAINT ville_spot_fk
FOREIGN KEY (ville_id)
REFERENCES public.ville (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT spot_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT spot_commentaire_fk
FOREIGN KEY (spot_id)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT spot_topo_fk
FOREIGN KEY (spot_id)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT topo_reservation_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT topo_commentaire_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur ADD CONSTRAINT role_utilisateur_fk
FOREIGN KEY (role_id)
REFERENCES public.role (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT utilisateur_reservation_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
