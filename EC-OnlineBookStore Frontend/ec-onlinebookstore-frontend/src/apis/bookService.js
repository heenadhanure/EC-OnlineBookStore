import axios from "./axiosConfig";

export const saveOrUpdateBook = () =>
  axios.post(`/books/saveorupdatebook`);

export const getBookById = (id) =>
  axios.get(`/books/getBookById/${id}`);

export const getBookByTitle = (id) =>
  axios.get(`/books/getBookByTitle/${id}`);

export const getAllBooks = () =>
  axios.get(`/books/getallbooks`);

export const deleteBookById = () =>
  axios.delete(`/books/deletebyid/{id}`);

export const deleteBookByTitle = () =>
  axios.delete(`/books/deletebytitle/{bookTitle}`);



