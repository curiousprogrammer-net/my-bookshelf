ALTER TABLE books DROP COLUMN author;

CREATE TABLE books_authors
(id VARCHAR(20) PRIMARY KEY,
 book_id VARCHAR(20) REFERENCES books(id),
 author_id VARCHAR(20) REFERENCES authors(id));
