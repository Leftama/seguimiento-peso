#!/bin/bash
echo "Iniciando servidor Spark Java..."
mvn exec:java -Dexec.mainClass="com.healthtrack.App" &
APP_PID=$!

echo "⏳ Esperando que el servidor esté disponible en http://localhost:4567..."
until curl -s http://localhost:4567 >/dev/null; do
  sleep 1
done

echo "✅ Servidor activo. Ejecutando pruebas funcionales..."
mvn test -Pfuncionales

echo "Deteniendo servidor (PID $APP_PID)..."
kill $APP_PID

mvn verify

echo "✅ Proceso de pruebas completo."
