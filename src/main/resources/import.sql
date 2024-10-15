INSERT INTO sedes (nombre_sede, ubicacion_mapa, direccion) VALUES ('Sede Central', 'Ubicación Central', 'Av. Principal 123');
INSERT INTO sedes (nombre_sede, ubicacion_mapa, direccion) VALUES ('Sede Norte', 'Ubicación Norte', 'Calle 45 - Zona Norte');
INSERT INTO sedes (nombre_sede, ubicacion_mapa, direccion) VALUES ('Sede Sur', 'Ubicación Sur', 'Calle 78 - Zona Sur');

INSERT INTO rifas (nombre_rifa, fecha_rifa, precio_boleto, cantidad_boleto, sedes_id_Sede) VALUES ('Rifa de Verano', '2024-12-01', 10.00, 100, 1);
INSERT INTO rifas (nombre_rifa, fecha_rifa, precio_boleto, cantidad_boleto, sedes_id_Sede) VALUES ('Rifa de Invierno', '2025-01-15', 15.00, 150, 2);
INSERT INTO rifas (nombre_rifa, fecha_rifa, precio_boleto, cantidad_boleto, sedes_id_Sede) VALUES ('Rifa de Primavera', '2025-03-20', 12.00, 120, 3);
