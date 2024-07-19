FROM python:3.10-alpine
LABEL authors="jubel"

WORKDIR /app

COPY gateway.py .

RUN pip install flask

ENTRYPOINT ["python", "gateway.py"]