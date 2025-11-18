import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginModal from "../components/LoginModal/LoginModal";

import MainLayout from "../layouts/MainLayout";

// Pages
import Home from "../pages/Home/Home";
import Books from "../pages/Books/Books";
import BookDetails from "../pages/BookDetails/BookDetails";
import Cart from "../pages/Cart/Cart";
import Checkout from "../pages/Checkout/Checkout";
import Orders from "../pages/Orders/Orders";
import Login from "../pages/Login/Login";
import Register from "../pages/Register/Register";
import Profile from "../pages/Profile/Profile";

export default function AppRoutes() {
  const [openLogin, setOpenLogin] = useState(false);

  return (
    <BrowserRouter>

      {/* Login Modal */}
      <LoginModal
        isOpen={openLogin}
        onClose={() => setOpenLogin(false)}
      />

      <Routes>

        {/* Layout routes */}
        <Route element={<MainLayout setOpenLogin={setOpenLogin} />}>
          <Route path="/" element={<Home />} />
          <Route path="/books" element={<Books />} />
          <Route path="/books/:id" element={<BookDetails />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/checkout" element={<Checkout />} />
          <Route path="/orders" element={<Orders />} />
          <Route path="/profile" element={<Profile />} />
        </Route>

        {/* Non-layout routes */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

      </Routes>
    </BrowserRouter>
  );
}
