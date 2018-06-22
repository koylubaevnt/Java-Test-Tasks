--
-- File generated with SQLiteStudio v3.1.1 on Ср дек 21 11:22:31 2016
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: StaffingStructure
CREATE TABLE [StaffingStructure] ([ID] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,[DepCode] VARCHAR(20)  NULL,[DepJob] VARCHAR(100)  NULL,[Description] VARCHAR(255)  NULL);
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (1, 'Администрация', 'Генеральный директор', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (2, 'Администрация', 'Главный бухгалтер', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (3, 'Администрация', 'Директор ОП г. Пермь', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (4, 'Администрация', 'Заместитель генерального директора по развитию', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (5, 'Администрация', 'Заместитель генерального директора по внедрению и сопровождению Информационных систем', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (6, 'Систем АЗС', 'Начальник департамента', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (7, 'Систем АЗС', 'Начальник Управления развития', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (8, 'Систем АЗС', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (9, 'Систем АЗС', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (10, 'Систем АЗС', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (11, 'Систем АЗС', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (12, 'Систем Нефтебаз', 'Начальник департамента', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (13, 'Систем Нефтебаз', 'Начальник Управления', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (14, 'Систем Нефтебаз', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (15, 'Систем Нефтебаз', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (16, 'Систем Нефтебаз', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (17, 'Систем Нефтебаз', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (18, 'Систем АСУ ТП', 'Начальник департамента', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (19, 'Систем АСУ ТП', 'Начальник Управления', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (20, 'Систем АСУ ТП', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (21, 'Систем АСУ ТП', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (22, 'Систем АСУ ТП', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (23, 'Систем АСУ ТП', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (24, 'Иноформ. системы', 'Начальник департамента', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (25, 'Иноформ. системы', 'Начальник управления развития ИС', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (26, 'Иноформ. системы', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (27, 'Иноформ. системы', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (28, 'Иноформ. системы', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (29, 'Иноформ. системы', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (30, 'Интеграция ИС', 'Начальник управления интеграции ИС', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (31, 'Интеграция ИС', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (32, 'Интеграция ИС', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (33, 'Интеграция ИС', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (34, 'Интеграция ИС', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (35, 'Учетные системы', 'Начальник Управления развития Учетных систем', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (36, 'Учетные системы', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (37, 'Учетные системы', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (38, 'Учетные системы', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (39, 'Учетные системы', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (40, 'Аналитические систем', 'Начальник Управления развития Аналитических систем', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (41, 'Аналитические систем', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (42, 'Аналитические систем', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (43, 'Аналитические систем', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (44, 'Аналитические систем', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (45, 'Иноформ.Системы(вн)', 'Начальник департамента', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (46, 'Иноформ.Системы(вн)', 'Начальник управления', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (47, 'Иноформ.Системы(вн)', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (48, 'Иноформ.Системы(вн)', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (49, 'Иноформ.Системы(вн)', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (50, 'Иноформ.Системы(вн)', 'Специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (51, 'Иноформ.Системы(соп)', 'Начальник департамента', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (52, 'Иноформ.Системы(соп)', 'Начальник Управления', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (53, 'Иноформ.Системы(соп)', 'Начальник отдела', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (54, 'Иноформ.Системы(соп)', 'Главный специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (55, 'Иноформ.Системы(соп)', 'Ведущий специалист', 'Инициализация БД');
INSERT INTO StaffingStructure (ID, DepCode, DepJob, Description) VALUES (56, 'Иноформ.Системы(соп)', 'Специалист', 'Инициализация БД');

-- Index: IDX_STAFFINGSTRUCTURE_UNIQUE
CREATE UNIQUE INDEX [IDX_STAFFINGSTRUCTURE_UNIQUE] ON [StaffingStructure]([DepCode]  ASC,[DepJob]  ASC);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
