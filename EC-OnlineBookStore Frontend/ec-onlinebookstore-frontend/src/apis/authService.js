import axiosInstance from "./axiosConfig";

// ✅ Register User
export const registerUser = async (formData) => {
  try {
    const response = await axiosInstance.post("/user/userregisters", formData);
    return response.data;
  } catch (error) {
    throw error.response?.data || "Registration failed";
  }
};

// ✅ Login User
export const loginUser = async (data) => {
  try {
    const response = await axiosInstance.post("/user/userlogin", data);
    return response.data;
  } catch (error) {
    throw error.response?.data || "Login failed";
  }
};

// ✅ User Register With Files (multipart)
export const userRegisterWithFiles = (data) =>
  axiosInstance.post("/user/userregistersuploadmulti", data);

// ✅ Get User Details by ID
export const getUserDetails = (id) =>
  axiosInstance.get(`/user/userDetails/${id}`);

// ✅ Get All Users
export const getAllUsers = () =>
  axiosInstance.get(`/user/getAllUsers`);

