import logging

from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from .serializers import *


class BooksListView(APIView):
    @staticmethod
    def get(request):
        books = Book.objects.all()
        serializer = BookSerializer(instance=books, many=True)
        return Response(serializer.data)


class BooksDetailView(APIView):
    @staticmethod
    def get(request, pk):
        try:
            book = Book.objects.get(pk=pk)
            serializer = BookSerializer(instance=book)
        except Exception as e:
            logging.exception(e)
            return Response(status=status.HTTP_404_NOT_FOUND)
        return Response(serializer.data)

    @staticmethod
    def post(request):
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    @staticmethod
    def put(request, pk):
        try:
            book = Book.objects.get(pk=pk)
            serializer = BookSerializer(instance=book)
        except Exception as e:
            logging.exception(e)
            return Response(status=status.HTTP_404_NOT_FOUND)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    @staticmethod
    def delete(request, pk):
        try:
            book = Book.objects.get(pk=pk)
        except Exception as e:
            logging.exception(e)
            return Response(status=status.HTTP_404_NOT_FOUND)
        book.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class AuthorsListView(APIView):
    @staticmethod
    def get(request):
        authors = Author.objects.all()
        serializer = AuthorSerializer(instance=authors, many=True)
        return Response(serializer.data)


class AuthorsDetailView(APIView):
    @staticmethod
    def get(request, pk):
        author = Author.objects.get(pk=pk)
        serializer = AuthorSerializer(instance=author)
        return Response(serializer.data)

    @staticmethod
    def post(request):
        serializer = AuthorSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    @staticmethod
    def put(request, pk):
        author = Author.objects.get(pk=pk)
        serializer = AuthorSerializer(instance=author, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    @staticmethod
    def delete(request, pk):
        author = Author.objects.get(pk=pk)
        author.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class LibrariesListView(APIView):
    @staticmethod
    def get(request):
        libraries = Library.objects.all()
        serializer = LibrarySerializer(instance=libraries, many=True)
        return Response(serializer.data)


class LibrariesDetailView(APIView):
    @staticmethod
    def get(request, pk):
        library = Library.objects.get(pk=pk)
        serializer = LibrarySerializer(instance=library)
        return Response(serializer.data)

    @staticmethod
    def post(request):
        serializer = LibrarySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    @staticmethod
    def put(request, pk):
        library = Library.objects.get(pk=pk)
        serializer = LibrarySerializer(instance=library, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    @staticmethod
    def delete(request, pk):
        library = Library.objects.get(pk=pk)
        library.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
