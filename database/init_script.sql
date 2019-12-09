INSERT INTO public.study_form (name) VALUES ('Очная платная');
INSERT INTO public.study_form (name) VALUES ('Очная бесплатная');
INSERT INTO public.study_form (name) VALUES ('Заочная платная');
INSERT INTO public.study_form (name) VALUES ('Заочная бесплатная');
INSERT INTO public.study_form (name) VALUES ('Дистанционная платная');
INSERT INTO public.study_form (name) VALUES ('Дистанционная бесплатная');

INSERT INTO public.occupation_type (name) VALUES ('Лекция');
INSERT INTO public.occupation_type (name) VALUES ('Семинар');
INSERT INTO public.occupation_type (name) VALUES ('Лабораторная работа');
INSERT INTO public.occupation_type (name) VALUES ('Консультация');
INSERT INTO public.occupation_type (name) VALUES ('Курсовая работа');
INSERT INTO public.occupation_type (name) VALUES ('Самостоятельная работы');
INSERT INTO public.occupation_type (name) VALUES ('Зачет');
INSERT INTO public.occupation_type (name) VALUES ('Экзамен');

INSERT INTO public.relationship_type (name) VALUES ('Мать');
INSERT INTO public.relationship_type (name) VALUES ('Отец');
INSERT INTO public.relationship_type (name) VALUES ('Бабушка');
INSERT INTO public.relationship_type (name) VALUES ('Дедушка');
INSERT INTO public.relationship_type (name) VALUES ('Официальный представитель');
INSERT INTO public.relationship_type (name) VALUES ('Брат');
INSERT INTO public.relationship_type (name) VALUES ('Сестра');

INSERT INTO public.teacher_type (name) VALUES ('Ассистент');
INSERT INTO public.teacher_type (name) VALUES ('Преподаватель');
INSERT INTO public.teacher_type (name) VALUES ('Старший преподаватель');
INSERT INTO public.teacher_type (name) VALUES ('Доцент');
INSERT INTO public.teacher_type (name) VALUES ('Профессор');

INSERT INTO public.faculty (name) VALUES ('Информационные технолгии');

INSERT INTO public.department (name, id_faculty) VALUES ('Вычислительные системы и сети', 1);
INSERT INTO public.department (name, id_faculty) VALUES ('Геодезия и геоинформационные системы', 1);
INSERT INTO public.department (name, id_faculty) VALUES ('Технологии программирования', 1);

INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '16-ИТ-1', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '16-ИТ-2', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '16-ИТ-3', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 2, '16-ВС', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 2, '16-КБ', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 3, '16-ГЕО-1', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 3, '16-ГЕО-2', '2016-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '17-ИТ-1', '2017-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '17-ИТ-2', '2017-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '17-ИТ-3', '2017-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '17-ИТ-4', '2017-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 2, '17-ВС', '2017-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 3, '17-ГЕО', '2017-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '18-ИТ-1', '2018-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '18-ИТ-2', '2018-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '18-ИТ-3', '2018-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '18-ИТ-4', '2018-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 2, '18-ВС', '2018-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 3, '18-ГЕО', '2018-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '19-МС', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 2, '19-КБ', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 2, '19-ВС', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '19-ИТ-1', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '19-ИТ-2', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '19-ИТ-3', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 1, '19-ИТ-4', '2019-09-01 00:00:00.000000', null);
INSERT INTO public."group" (id_faculty, id_department, name, created_date, id_headman) VALUES (1, 3, '19-ГЕО', '2019-09-01 00:00:00.000000', null);

INSERT INTO public.human (first_name, last_name, middle_name, phone_number, email, birth_date, sex) VALUES ('Андрей', 'Яблонский', '', '+375296514584', 'wiski.w@gmail.com', '1998-09-23 00:00:00.000000', 'm');
INSERT INTO public.human (first_name, last_name, middle_name, phone_number, email, birth_date, sex) VALUES ('Константин', 'Щербицкий', 'Олегович', '+375336134342', 'kostya.em2@gmail.com', '1999-01-08 00:00:00.000000', 'm');

INSERT INTO public.student (id_record_book, id_human, id_group, id_study_form, admission_date, has_children, course_number) VALUES ('651654654', 3, 2, 1, '2016-09-01 00:00:00.000000', false, null);
INSERT INTO public.student (id_record_book, id_human, id_group, id_study_form, admission_date, has_children, course_number) VALUES ('345234523', 4, 3, 1, '2016-09-01 00:00:00.000000', false, null);