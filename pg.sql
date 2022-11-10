--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-11-10 03:42:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16417)
-- Name: client; Type: TABLE; Schema: public; Owner: Danylo
--

CREATE TABLE public.client (
    client_id bigint NOT NULL,
    name character varying(30) NOT NULL,
    age numeric,
    phone character varying(30) NOT NULL
);


ALTER TABLE public.client OWNER TO "Danylo";

--
-- TOC entry 211 (class 1259 OID 16416)
-- Name: client_client_id_seq; Type: SEQUENCE; Schema: public; Owner: Danylo
--

CREATE SEQUENCE public.client_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.client_client_id_seq OWNER TO "Danylo";

--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 211
-- Name: client_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Danylo
--

ALTER SEQUENCE public.client_client_id_seq OWNED BY public.client.client_id;


--
-- TOC entry 214 (class 1259 OID 16426)
-- Name: client_email; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client_email (
    client_id bigint NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE public.client_email OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16425)
-- Name: client_email_client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_email_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.client_email_client_id_seq OWNER TO postgres;

--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 213
-- Name: client_email_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_email_client_id_seq OWNED BY public.client_email.client_id;


--
-- TOC entry 217 (class 1259 OID 16486)
-- Name: exchange_rate; Type: TABLE; Schema: public; Owner: Danylo
--

CREATE TABLE public.exchange_rate (
    rate_to_uah double precision NOT NULL,
    currency_name character varying(50) NOT NULL,
    updated_at timestamp without time zone NOT NULL
);


ALTER TABLE public.exchange_rate OWNER TO "Danylo";

--
-- TOC entry 210 (class 1259 OID 16408)
-- Name: movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie (
    movie_id bigint NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(100) NOT NULL,
    genre character varying(100) NOT NULL,
    country character varying(100) NOT NULL
);


ALTER TABLE public.movie OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16407)
-- Name: movie_movie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movie_movie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movie_movie_id_seq OWNER TO postgres;

--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 209
-- Name: movie_movie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movie_movie_id_seq OWNED BY public.movie.movie_id;


--
-- TOC entry 215 (class 1259 OID 16437)
-- Name: ticket; Type: TABLE; Schema: public; Owner: Danylo
--

CREATE TABLE public.ticket (
    cost numeric NOT NULL,
    ticket_id bigint NOT NULL,
    client_id bigint NOT NULL,
    movie_id bigint NOT NULL
);


ALTER TABLE public.ticket OWNER TO "Danylo";

--
-- TOC entry 216 (class 1259 OID 16442)
-- Name: ticket_ticket_id_seq; Type: SEQUENCE; Schema: public; Owner: Danylo
--

CREATE SEQUENCE public.ticket_ticket_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ticket_ticket_id_seq OWNER TO "Danylo";

--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 216
-- Name: ticket_ticket_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Danylo
--

ALTER SEQUENCE public.ticket_ticket_id_seq OWNED BY public.ticket.ticket_id;


--
-- TOC entry 3184 (class 2604 OID 16420)
-- Name: client client_id; Type: DEFAULT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.client ALTER COLUMN client_id SET DEFAULT nextval('public.client_client_id_seq'::regclass);


--
-- TOC entry 3185 (class 2604 OID 16429)
-- Name: client_email client_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_email ALTER COLUMN client_id SET DEFAULT nextval('public.client_email_client_id_seq'::regclass);


--
-- TOC entry 3183 (class 2604 OID 16411)
-- Name: movie movie_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie ALTER COLUMN movie_id SET DEFAULT nextval('public.movie_movie_id_seq'::regclass);


--
-- TOC entry 3186 (class 2604 OID 16443)
-- Name: ticket ticket_id; Type: DEFAULT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.ticket ALTER COLUMN ticket_id SET DEFAULT nextval('public.ticket_ticket_id_seq'::regclass);


--
-- TOC entry 3342 (class 0 OID 16417)
-- Dependencies: 212
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: Danylo
--

COPY public.client (client_id, name, age, phone) FROM stdin;
1	Danylo	19	+380685835147
2	Polina	18	+380666666666
3	Dmytro	21	+380333333333
4	Anastatsia	19	+380123123123
5	Oleh	20	+380567546376
\.


--
-- TOC entry 3344 (class 0 OID 16426)
-- Dependencies: 214
-- Data for Name: client_email; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client_email (client_id, email) FROM stdin;
1	hehe@gmail.com
2	yea@gmail.com
3	nya@yahoo.com
4	ehehe@rus.ni.peace.da
5	oleh.hordienko@gmail.com
\.


--
-- TOC entry 3347 (class 0 OID 16486)
-- Dependencies: 217
-- Data for Name: exchange_rate; Type: TABLE DATA; Schema: public; Owner: Danylo
--

COPY public.exchange_rate (rate_to_uah, currency_name, updated_at) FROM stdin;
39.9	USD	2022-10-16 22:59:24.9498
38.1	EUR	2022-10-16 22:59:24.956797
\.


--
-- TOC entry 3340 (class 0 OID 16408)
-- Dependencies: 210
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movie (movie_id, name, description, genre, country) FROM stdin;
0	movieTest	Сматрєть всєм	Екшн, історичний	США
2	Чорний Адам 	Минуло майже 5000 років відтоді, як стародавні боги зробили Чорного Адама	 Фантастика, Екшн 	США
3	Посіпаки: Становлення лиходія 	Посіпаки, жовті і невгамовні повелителі мільйонів, проведуть вас туди, де все почалося. 	 Пригоди, Анімація, Сімейний, Фентезі 	США
1	Кохання напрокат	Поппі — фахівець з маркетингу, чиє життя перевертається з ніг на голову	 Комедія, Мелодрама 	США
4	Королева - воїн 	Надзвичайна історія, натхненна реальними подіями. Фільм розкаже про силу та відвагу жінок, які вибор	 Екшн, історичний	США
\.


--
-- TOC entry 3345 (class 0 OID 16437)
-- Dependencies: 215
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: Danylo
--

COPY public.ticket (cost, ticket_id, client_id, movie_id) FROM stdin;
100	7	1	3
120	8	2	1
90	9	4	3
70	10	5	2
150	11	1	4
150	12	2	4
130	13	3	1
\.


--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 211
-- Name: client_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Danylo
--

SELECT pg_catalog.setval('public.client_client_id_seq', 5, true);


--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 213
-- Name: client_email_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_email_client_id_seq', 5, true);


--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 209
-- Name: movie_movie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movie_movie_id_seq', 4, true);


--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 216
-- Name: ticket_ticket_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Danylo
--

SELECT pg_catalog.setval('public.ticket_ticket_id_seq', 13, true);


--
-- TOC entry 3192 (class 2606 OID 16431)
-- Name: client_email client_email_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_email
    ADD CONSTRAINT client_email_pkey PRIMARY KEY (client_id);


--
-- TOC entry 3190 (class 2606 OID 16424)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (client_id);


--
-- TOC entry 3196 (class 2606 OID 16490)
-- Name: exchange_rate currency_name; Type: CONSTRAINT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.exchange_rate
    ADD CONSTRAINT currency_name PRIMARY KEY (currency_name);


--
-- TOC entry 3188 (class 2606 OID 16413)
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (movie_id);


--
-- TOC entry 3194 (class 2606 OID 16450)
-- Name: ticket ticket_id; Type: CONSTRAINT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_id PRIMARY KEY (ticket_id);


--
-- TOC entry 3197 (class 2606 OID 16432)
-- Name: client_email client_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_email
    ADD CONSTRAINT client_id FOREIGN KEY (client_id) REFERENCES public.client(client_id);


--
-- TOC entry 3198 (class 2606 OID 16457)
-- Name: ticket client_id; Type: FK CONSTRAINT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT client_id FOREIGN KEY (client_id) REFERENCES public.client(client_id);


--
-- TOC entry 3199 (class 2606 OID 16468)
-- Name: ticket movie_id; Type: FK CONSTRAINT; Schema: public; Owner: Danylo
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT movie_id FOREIGN KEY (movie_id) REFERENCES public.movie(movie_id);


-- Completed on 2022-11-10 03:42:39

--
-- PostgreSQL database dump complete
--

