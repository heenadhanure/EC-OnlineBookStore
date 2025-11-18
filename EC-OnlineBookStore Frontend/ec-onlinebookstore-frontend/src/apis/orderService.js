import axios from "./axiosConfig";

export const placeOrder = (data) =>
  axios.post(`/orders/placeorder`, data);

export const getOrdersByUser = (userId) =>
  axios.get(`/orders/user/${userId}`);

