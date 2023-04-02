FROM postgres:15.2-alpine

LABEL author="Rathna Prakash"
LABEL author_email="rathna.prakash@gmail.com"
LABEL description="Postgres Image for Leanrings"
LABEL version="1.0"

COPY *.sql /docker-entrypoint-initdb.d/