import axios from "./axiosConfig";

export const getRatingsByBookId = (bookId) =>
  axios.get(`/ratings/book/${bookId}`);

export const addRating = (data) =>
  axios.post(`/ratings/ratingbooks`, data);
