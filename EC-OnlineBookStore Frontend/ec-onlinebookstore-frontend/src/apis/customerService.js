import axios from "./axiosConfig";

export const getCustomerById = (id) =>
  axios.get(`/customer/getbyid/${id}`);
