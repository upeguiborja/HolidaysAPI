INSERT INTO types (id, type)
VALUES (1, 'FIXED'),
       (2, 'LONG_WEEKEND'),
       (3, 'EASTER_BASED'),
       (4, 'LONG_WEEKEND_EASTER_BASED')
ON CONFLICT DO NOTHING;


INSERT INTO holidays (id, day, month, name, id_type, easter_day_offset)
VALUES (1, 01, 01, 'Año nuevo', 1, NULL),
       (2, 06, 01, 'Santos Reyes', 2, NULL),
       (3, 19, 03, 'San José', 2, NULL),
       (4, NULL, NULL, 'Jueves Santo', 3, -3),
       (5, NULL, NULL, 'Viernes Santo', 3, -2),
       (6, NULL, NULL, 'Domingo de Pascua', 3, 0),
       (7, 01, 05, 'Dia del Trabajo', 1, NULL),
       (8, NULL, NULL, 'Ascensión del Señor', 4, 40),
       (9, NULL, NULL, 'Corpus Christi', 4, 61),
       (10, NULL, NULL, 'Sagrado Corazón de Jesús', 4, 68),
       (11, 29, 06, 'San Pedro y San Pablo', 2, NULL),
       (12, 20, 07, 'Independencia Colombia', 1, NULL),
       (13, 07, 08, 'Batalla de Boyacá', 1, NULL),
       (14, 15, 08, 'Asunción de la Virgen', 2, NULL),
       (15, 12, 10, 'Dia de la Raza', 2, NULL),
       (16, 01, 11, 'Todos los Santos', 2, NULL),
       (17, 11, 11, 'Independencia de Cartagena', 2, NULL),
       (18, 08, 12, 'Inmaculada Concepción', 1, NULL),
       (19, 25, 12, 'Navidad', 1, NULL)
ON CONFLICT DO NOTHING;