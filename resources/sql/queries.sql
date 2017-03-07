-- TODO: there can be multiple authors -> create separate table!

-- :name create-book! :! :n
-- :doc persists a new book
INSERT INTO books
(id, title, author, issued, status)
 VALUES (:id, :title, :author, :issued, :status)

-- :name update-book! :! :n
-- :doc update an existing book
UPDATE books
SET title = :title, author = :author, issued = :issued, status = :status
WHERE id = :id

-- :name get-books :? :*
-- :doc retrieve all books
SELECT * FROM books

-- :name get-book :? :1
-- :doc retrieve a book given the id.
SELECT * FROM books
WHERE id = :id

-- :name delete-book! :! :n
-- :doc delete a book given the id
DELETE FROM books
WHERE id = :id


-- :name create-author! :! :n
-- :doc persists a new author
INSERT INTO authors
(id, first_name, last_name)
VALUES (:id, :first-name, :last-name)

-- :name update-author! :! :n
-- :doc update an existing author
UPDATE authors
SET first_name = :first-name, last_name = :last-name
WHERE id = :id

-- :name get-authors :? :*
-- :doc retrieve all authors
SELECT * FROM authors

-- :name get-author :? :1
-- :doc retrieve an author given the id.
SELECT * FROM authors
WHERE id = :id

-- :name delete-author! :! :n
-- :doc delete an author given the id
DELETE FROM authors
WHERE id = :id
