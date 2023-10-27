# Используем базовый образ Python
FROM python:3.10

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем зависимости проекта и устанавливаем их
COPY requirements.txt .
RUN pip install -r requirements.txt

# Копируем исходный код Django приложения
COPY prac5/ .

# Запускаем Django сервер
RUN python manage.py makemigrations
RUN python manage.py migrate
CMD ["python", "manage.py", "runserver", "0.0.0.0:8081"]