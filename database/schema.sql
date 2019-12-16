--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_with_oids = false;

--
-- Name: account; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.account (
    id_account bigint NOT NULL,
    username character varying(30) NOT NULL,
    password character varying(256) NOT NULL,
    user_role character varying(10) NOT NULL,
    created_date timestamp without time zone DEFAULT now()
);


--
-- Name: account_id_account_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.account_id_account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: account_id_account_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.account_id_account_seq OWNED BY public.account.id_account;


--
-- Name: curator; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.curator (
    id_group bigint NOT NULL,
    id_human bigint NOT NULL
);


--
-- Name: TABLE curator; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.curator IS 'Куратор';


--
-- Name: department; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.department (
    id_department bigint NOT NULL,
    name character varying(50) NOT NULL,
    id_faculty bigint NOT NULL
);


--
-- Name: TABLE department; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.department IS 'Кафедра';


--
-- Name: COLUMN department.name; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.department.name IS 'Название кафедры';


--
-- Name: department_id_department_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.department_id_department_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: department_id_department_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.department_id_department_seq OWNED BY public.department.id_department;


--
-- Name: discipline; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.discipline (
    id_discipline bigint NOT NULL,
    name character varying(50) NOT NULL
);


--
-- Name: COLUMN discipline.name; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.discipline.name IS 'Название дисциплины';


--
-- Name: discipline_id_discipline_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.discipline_id_discipline_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: discipline_id_discipline_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.discipline_id_discipline_seq OWNED BY public.discipline.id_discipline;


--
-- Name: expelled; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.expelled (
    id_student bigint NOT NULL,
    date_expelled timestamp without time zone NOT NULL,
    by_choice boolean
);


--
-- Name: TABLE expelled; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.expelled IS 'Отчісленные';


--
-- Name: COLUMN expelled.by_choice; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.expelled.by_choice IS 'По собственному желанию или нет';


--
-- Name: faculty; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.faculty (
    id_faculty bigint NOT NULL,
    name character varying(50) NOT NULL
);


--
-- Name: COLUMN faculty.name; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.faculty.name IS 'Название факультета';


--
-- Name: faculty_id_faculty_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.faculty_id_faculty_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: faculty_id_faculty_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.faculty_id_faculty_seq OWNED BY public.faculty.id_faculty;


--
-- Name: grade; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.grade (
    id_student bigint NOT NULL,
    id_teacher bigint NOT NULL,
    grade integer NOT NULL,
    created_date timestamp with time zone DEFAULT now() NOT NULL,
    id_study_plan bigint NOT NULL
);


--
-- Name: TABLE grade; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.grade IS 'Оценки';


--
-- Name: COLUMN grade.created_date; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.grade.created_date IS 'Дата выставленной оценки';


--
-- Name: grant; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."grant" (
    id_student bigint NOT NULL,
    active boolean NOT NULL
);


--
-- Name: TABLE "grant"; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public."grant" IS 'Именная стипендия';


--
-- Name: group; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."group" (
    id_group bigint NOT NULL,
    id_department bigint NOT NULL,
    name character varying(30) NOT NULL,
    created_date timestamp without time zone NOT NULL,
    id_headman bigint NOT NULL
);


--
-- Name: TABLE "group"; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public."group" IS 'Группа';


--
-- Name: group_id_group_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.group_id_group_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: group_id_group_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.group_id_group_seq OWNED BY public."group".id_group;


--
-- Name: human; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.human (
    id_human bigint NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    middle_name character varying(30),
    phone_number character varying(15) NOT NULL,
    email character varying(50) NOT NULL,
    birth_date timestamp without time zone NOT NULL
);


--
-- Name: TABLE human; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.human IS 'Обитатели университета';


--
-- Name: human_id_human_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.human_id_human_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: human_id_human_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.human_id_human_seq OWNED BY public.human.id_human;


--
-- Name: occupation_type; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.occupation_type (
    id_occupation bigint NOT NULL,
    name character varying(35) NOT NULL
);


--
-- Name: TABLE occupation_type; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.occupation_type IS 'Тип занятий';


--
-- Name: occupation_type_id_occupation_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.occupation_type_id_occupation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: occupation_type_id_occupation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.occupation_type_id_occupation_seq OWNED BY public.occupation_type.id_occupation;


--
-- Name: relationship_type; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.relationship_type (
    id_relationship bigint NOT NULL,
    name character varying(35) NOT NULL
);


--
-- Name: TABLE relationship_type; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.relationship_type IS 'Типы родствнных свзяей';


--
-- Name: COLUMN relationship_type.name; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.relationship_type.name IS 'Название(напр. мама, папа)';


--
-- Name: relationship_type_id_relationship_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.relationship_type_id_relationship_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: relationship_type_id_relationship_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.relationship_type_id_relationship_seq OWNED BY public.relationship_type.id_relationship;


--
-- Name: science_conf; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.science_conf (
    id_student bigint NOT NULL,
    conf_name character varying(50) NOT NULL,
    place integer,
    created_date timestamp with time zone DEFAULT now() NOT NULL
);


--
-- Name: TABLE science_conf; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.science_conf IS 'Научные конференции';


--
-- Name: stipend; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.stipend (
    id_student bigint NOT NULL,
    amount double precision
);


--
-- Name: TABLE stipend; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.stipend IS 'Стипендия';


--
-- Name: student; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.student (
    id_student bigint NOT NULL,
    id_record_book character varying(15) NOT NULL,
    id_human bigint NOT NULL,
    id_group bigint NOT NULL,
    id_study_form bigint NOT NULL,
    admission_date timestamp without time zone NOT NULL
);


--
-- Name: TABLE student; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.student IS 'Студент';


--
-- Name: COLUMN student.id_record_book; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.student.id_record_book IS 'Номер зачетной книжки';


--
-- Name: student_address; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.student_address (
    id_student bigint,
    country character varying(30) NOT NULL,
    city character varying(30) NOT NULL,
    street character varying(30) NOT NULL,
    house integer NOT NULL,
    building integer,
    flat integer NOT NULL,
    legal_address boolean DEFAULT false NOT NULL
);


--
-- Name: COLUMN student_address.building; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.address.building IS 'Корпус';


--
-- Name: COLUMN student_address.legal_address; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.address.legal_address IS 'Официальное место прописки';


--
-- Name: student_id_student_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.student_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: student_id_student_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.student_id_student_seq OWNED BY public.student.id_student;


--
-- Name: student_parents; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.student_parents (
    id_student bigint NOT NULL,
    id_relationship bigint NOT NULL,
    id_human bigint NOT NULL
);


--
-- Name: study_form; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.study_form (
    id_study_form bigint NOT NULL,
    name character varying(30) NOT NULL
);


--
-- Name: TABLE study_form; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.study_form IS 'Форма обучения';


--
-- Name: study_form_id_study_form_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.study_form_id_study_form_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: study_form_id_study_form_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.study_form_id_study_form_seq OWNED BY public.study_form.id_study_form;


--
-- Name: study_plan; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.study_plan (
    id_discpline bigint NOT NULL,
    id_occupation_type bigint NOT NULL,
    hours double precision NOT NULL,
    course_number integer NOT NULL,
    semester_number integer NOT NULL,
    id_study_plan bigint NOT NULL
);


--
-- Name: TABLE study_plan; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.study_plan IS 'Учебный план';


--
-- Name: COLUMN study_plan.hours; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN public.study_plan.hours IS 'Количество часов';


--
-- Name: study_plan_id_study_plan_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.study_plan_id_study_plan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: study_plan_id_study_plan_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.study_plan_id_study_plan_seq OWNED BY public.study_plan.id_study_plan;


--
-- Name: teacher; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.teacher (
    id_teacher bigint NOT NULL,
    id_teacher_type bigint NOT NULL,
    id_faculty bigint NOT NULL,
    id_human bigint NOT NULL
);


--
-- Name: teacher_department; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.teacher_department (
    id_teacher bigint NOT NULL,
    id_department bigint NOT NULL
);


--
-- Name: teacher_id_teacher_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.teacher_id_teacher_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: teacher_id_teacher_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.teacher_id_teacher_seq OWNED BY public.teacher.id_teacher;


--
-- Name: teacher_type; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.teacher_type (
    id_teacher_type bigint NOT NULL,
    name character varying(30) NOT NULL
);


--
-- Name: TABLE teacher_type; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE public.teacher_type IS 'Категории прподавателя';


--
-- Name: teacher_type_id_teacher_type_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.teacher_type_id_teacher_type_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: teacher_type_id_teacher_type_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.teacher_type_id_teacher_type_seq OWNED BY public.teacher_type.id_teacher_type;


--
-- Name: account id_account; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.account ALTER COLUMN id_account SET DEFAULT nextval('public.account_id_account_seq'::regclass);


--
-- Name: department id_department; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.department ALTER COLUMN id_department SET DEFAULT nextval('public.department_id_department_seq'::regclass);


--
-- Name: discipline id_discipline; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.discipline ALTER COLUMN id_discipline SET DEFAULT nextval('public.discipline_id_discipline_seq'::regclass);


--
-- Name: faculty id_faculty; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.faculty ALTER COLUMN id_faculty SET DEFAULT nextval('public.faculty_id_faculty_seq'::regclass);


--
-- Name: group id_group; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."group" ALTER COLUMN id_group SET DEFAULT nextval('public.group_id_group_seq'::regclass);


--
-- Name: human id_human; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.human ALTER COLUMN id_human SET DEFAULT nextval('public.human_id_human_seq'::regclass);


--
-- Name: occupation_type id_occupation; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.occupation_type ALTER COLUMN id_occupation SET DEFAULT nextval('public.occupation_type_id_occupation_seq'::regclass);


--
-- Name: relationship_type id_relationship; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationship_type ALTER COLUMN id_relationship SET DEFAULT nextval('public.relationship_type_id_relationship_seq'::regclass);


--
-- Name: student id_student; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student ALTER COLUMN id_student SET DEFAULT nextval('public.student_id_student_seq'::regclass);


--
-- Name: study_form id_study_form; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.study_form ALTER COLUMN id_study_form SET DEFAULT nextval('public.study_form_id_study_form_seq'::regclass);


--
-- Name: study_plan id_study_plan; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.study_plan ALTER COLUMN id_study_plan SET DEFAULT nextval('public.study_plan_id_study_plan_seq'::regclass);


--
-- Name: teacher id_teacher; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher ALTER COLUMN id_teacher SET DEFAULT nextval('public.teacher_id_teacher_seq'::regclass);


--
-- Name: teacher_type id_teacher_type; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher_type ALTER COLUMN id_teacher_type SET DEFAULT nextval('public.teacher_type_id_teacher_type_seq'::regclass);


--
-- Name: account account_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pk PRIMARY KEY (id_account);


--
-- Name: department department_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pk PRIMARY KEY (id_department);


--
-- Name: discipline discipline_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.discipline
    ADD CONSTRAINT discipline_pk PRIMARY KEY (id_discipline);


--
-- Name: faculty faculty_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.faculty
    ADD CONSTRAINT faculty_pk PRIMARY KEY (id_faculty);


--
-- Name: group group_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."group"
    ADD CONSTRAINT group_pk PRIMARY KEY (id_group);


--
-- Name: human human_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.human
    ADD CONSTRAINT human_pk PRIMARY KEY (id_human);


--
-- Name: occupation_type occupation_type_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.occupation_type
    ADD CONSTRAINT occupation_type_pk PRIMARY KEY (id_occupation);


--
-- Name: relationship_type relationship_type_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationship_type
    ADD CONSTRAINT relationship_type_pk PRIMARY KEY (id_relationship);


--
-- Name: student student_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pk PRIMARY KEY (id_student);


--
-- Name: study_form study_form_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.study_form
    ADD CONSTRAINT study_form_pk PRIMARY KEY (id_study_form);


--
-- Name: study_plan study_plan_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.study_plan
    ADD CONSTRAINT study_plan_pk PRIMARY KEY (id_study_plan);


--
-- Name: teacher_department teacher_department_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher_department
    ADD CONSTRAINT teacher_department_pk PRIMARY KEY (id_teacher, id_department);


--
-- Name: teacher teacher_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pk PRIMARY KEY (id_teacher);


--
-- Name: teacher_type teacher_type_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher_type
    ADD CONSTRAINT teacher_type_pk PRIMARY KEY (id_teacher_type);


--
-- Name: account_id_account_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX account_id_account_uindex ON public.account USING btree (id_account);


--
-- Name: account_username_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX account_username_uindex ON public.account USING btree (username);


--
-- Name: department_id_department_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX department_id_department_uindex ON public.department USING btree (id_department);


--
-- Name: discipline_id_discipline_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX discipline_id_discipline_uindex ON public.discipline USING btree (id_discipline);


--
-- Name: faculty_id_faculty_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX faculty_id_faculty_uindex ON public.faculty USING btree (id_faculty);


--
-- Name: grade_id_student_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX grade_id_student_index ON public.grade USING btree (id_student);


--
-- Name: grade_id_teacher_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX grade_id_teacher_index ON public.grade USING btree (id_teacher);


--
-- Name: grant_id_student_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX grant_id_student_uindex ON public."grant" USING btree (id_student);


--
-- Name: group_id_group_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX group_id_group_uindex ON public."group" USING btree (id_group);


--
-- Name: human_id_human_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX human_id_human_uindex ON public.human USING btree (id_human);


--
-- Name: occupation_type_id_occupation_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX occupation_type_id_occupation_uindex ON public.occupation_type USING btree (id_occupation);


--
-- Name: relationship_type_id_relationship_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX relationship_type_id_relationship_uindex ON public.relationship_type USING btree (id_relationship);


--
-- Name: stipend_id_student_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX stipend_id_student_index ON public.stipend USING btree (id_student);


--
-- Name: student_address_id_student_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX student_address_id_student_index ON public.address USING btree (id_human);


--
-- Name: student_id_human_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX student_id_human_uindex ON public.student USING btree (id_human);


--
-- Name: student_id_record_book_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX student_id_record_book_uindex ON public.student USING btree (id_record_book);


--
-- Name: student_id_student_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX student_id_student_uindex ON public.student USING btree (id_student);


--
-- Name: student_parents_id_relationship_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX student_parents_id_relationship_index ON public.student_parents USING btree (id_relationship);


--
-- Name: student_parents_id_student_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX student_parents_id_student_index ON public.student_parents USING btree (id_student);


--
-- Name: study_form_id_study_form_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX study_form_id_study_form_uindex ON public.study_form USING btree (id_study_form);


--
-- Name: study_plan_id_study_plan_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX study_plan_id_study_plan_uindex ON public.study_plan USING btree (id_study_plan);


--
-- Name: teacher_department_id_department_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX teacher_department_id_department_index ON public.teacher_department USING btree (id_department);


--
-- Name: teacher_department_id_teacher_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX teacher_department_id_teacher_index ON public.teacher_department USING btree (id_teacher);


--
-- Name: teacher_id_faculty_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX teacher_id_faculty_index ON public.teacher USING btree (id_faculty);


--
-- Name: teacher_id_teacher_type_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX teacher_id_teacher_type_index ON public.teacher USING btree (id_teacher_type);


--
-- Name: teacher_id_teacher_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX teacher_id_teacher_uindex ON public.teacher USING btree (id_teacher);


--
-- Name: teacher_type_id_teacher_type_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX teacher_type_id_teacher_type_uindex ON public.teacher_type USING btree (id_teacher_type);


--
-- Name: curator curator_group_id_group_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.curator
    ADD CONSTRAINT curator_group_id_group_fk FOREIGN KEY (id_group) REFERENCES public."group"(id_group) ON DELETE CASCADE;


--
-- Name: curator curator_human_id_human_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.curator
    ADD CONSTRAINT curator_human_id_human_fk FOREIGN KEY (id_human) REFERENCES public.human(id_human) ON DELETE CASCADE;


--
-- Name: department department_faculty_id_faculty_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_faculty_id_faculty_fk FOREIGN KEY (id_faculty) REFERENCES public.faculty(id_faculty) ON DELETE CASCADE;


--
-- Name: expelled expelled_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.expelled
    ADD CONSTRAINT expelled_student_id_student_fk FOREIGN KEY (id_student) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: grade grade_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.grade
    ADD CONSTRAINT grade_student_id_student_fk FOREIGN KEY (id_student) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: grade grade_study_plan_id_study_plan_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.grade
    ADD CONSTRAINT grade_study_plan_id_study_plan_fk FOREIGN KEY (id_study_plan) REFERENCES public.study_plan(id_study_plan) ON DELETE CASCADE;


--
-- Name: grade grade_teacher_id_teacher_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.grade
    ADD CONSTRAINT grade_teacher_id_teacher_fk FOREIGN KEY (id_teacher) REFERENCES public.teacher(id_teacher) ON DELETE CASCADE;


--
-- Name: grant grant_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."grant"
    ADD CONSTRAINT grant_student_id_student_fk FOREIGN KEY (id_student) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: group group_department_id_department_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."group"
    ADD CONSTRAINT group_department_id_department_fk FOREIGN KEY (id_department) REFERENCES public.department(id_department) ON DELETE CASCADE;


--
-- Name: group group_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."group"
    ADD CONSTRAINT group_student_id_student_fk FOREIGN KEY (id_headman) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: science_conf science_conf_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.science_conf
    ADD CONSTRAINT science_conf_student_id_student_fk FOREIGN KEY (id_student) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: stipend stipend_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.stipend
    ADD CONSTRAINT stipend_student_id_student_fk FOREIGN KEY (id_student) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: student_address student_address_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT student_address_student_id_student_fk FOREIGN KEY (id_human) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: student student_group_id_group_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_group_id_group_fk FOREIGN KEY (id_group) REFERENCES public."group"(id_group) ON DELETE CASCADE;


--
-- Name: student student_human_id_human_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_human_id_human_fk FOREIGN KEY (id_human) REFERENCES public.human(id_human) ON DELETE CASCADE;


--
-- Name: student_parents student_parents_human_id_human_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student_parents
    ADD CONSTRAINT student_parents_human_id_human_fk FOREIGN KEY (id_human) REFERENCES public.human(id_human) ON DELETE CASCADE;


--
-- Name: student_parents student_parents_relationship_type_id_relationship_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student_parents
    ADD CONSTRAINT student_parents_relationship_type_id_relationship_fk FOREIGN KEY (id_relationship) REFERENCES public.relationship_type(id_relationship) ON DELETE CASCADE;


--
-- Name: student_parents student_parents_student_id_student_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student_parents
    ADD CONSTRAINT student_parents_student_id_student_fk FOREIGN KEY (id_student) REFERENCES public.student(id_student) ON DELETE CASCADE;


--
-- Name: student student_study_form_id_study_form_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_study_form_id_study_form_fk FOREIGN KEY (id_study_form) REFERENCES public.study_form(id_study_form) ON DELETE CASCADE;


--
-- Name: study_plan study_plan_discipline_id_discipline_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.study_plan
    ADD CONSTRAINT study_plan_discipline_id_discipline_fk FOREIGN KEY (id_discpline) REFERENCES public.discipline(id_discipline) ON DELETE CASCADE;


--
-- Name: study_plan study_plan_occupation_type_id_occupation_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.study_plan
    ADD CONSTRAINT study_plan_occupation_type_id_occupation_fk FOREIGN KEY (id_occupation_type) REFERENCES public.occupation_type(id_occupation) ON DELETE CASCADE;


--
-- Name: teacher_department teacher_department_department_id_department_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher_department
    ADD CONSTRAINT teacher_department_department_id_department_fk FOREIGN KEY (id_department) REFERENCES public.department(id_department) ON DELETE CASCADE;


--
-- Name: teacher_department teacher_department_teacher_id_teacher_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher_department
    ADD CONSTRAINT teacher_department_teacher_id_teacher_fk FOREIGN KEY (id_teacher) REFERENCES public.teacher(id_teacher) ON DELETE CASCADE;


--
-- Name: teacher teacher_faculty_id_faculty_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_faculty_id_faculty_fk FOREIGN KEY (id_faculty) REFERENCES public.faculty(id_faculty) ON DELETE CASCADE;


--
-- Name: teacher teacher_human_id_human_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_human_id_human_fk FOREIGN KEY (id_human) REFERENCES public.human(id_human) ON DELETE CASCADE;


--
-- Name: teacher teacher_teacher_type_id_teacher_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_teacher_type_id_teacher_type_fk FOREIGN KEY (id_teacher_type) REFERENCES public.teacher_type(id_teacher_type) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

