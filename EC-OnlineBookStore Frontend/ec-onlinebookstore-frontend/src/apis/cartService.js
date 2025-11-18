import axios from "./axiosConfig";

export const addToCart = (data) =>
  axios.post(`/cart/addtocart`, data);

export const getCartItem = (userId) =>
  axios.get(`/cart/${userId}`);

export const getAllCartItems = () =>
  axios.get(`/cart/retrieveitemsfromcart`);

export const removeFromCart = (cartItemId) =>
  axios.delete(`/cart/remove/${cartItemId}`);
