from django.db import models


class Author(models.Model):
    name = models.CharField(max_length=100)


class Library(models.Model):
    name = models.CharField(max_length=100)
    location = models.CharField(max_length=100)


class Book(models.Model):
    title = models.CharField(max_length=100)
    isbn = models.CharField(max_length=13, unique=True)
    library = models.ForeignKey(Library, on_delete=models.CASCADE)
    author = models.ForeignKey(Author, on_delete=models.CASCADE)
    publish_date = models.DateField()
    description = models.TextField()
