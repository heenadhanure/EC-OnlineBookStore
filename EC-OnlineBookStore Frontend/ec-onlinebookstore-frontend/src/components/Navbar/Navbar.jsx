import { Link } from "react-router-dom";
import "./Navbar.css";
import React, { useState } from "react";
import { FaSearch, FaShoppingCart } from "react-icons/fa";
import logo from "../../assets/logo.png";

export default function Navbar({ setOpenLogin }) {
  const [searchQuery, setSearchQuery] = useState("");
  const [cartCount, setCartCount] = useState(0);

  const handleSearch = (e) => {
    e.preventDefault();
    console.log("Searching for:", searchQuery);
  };

  return (
    <>
      <nav className="navbar">
        <div className="nav-container">

          <Link to="/">
            <img src={logo} alt="EC Online Bookstore" className="logo-img" />
          </Link>

          <form className="search-bar" onSubmit={handleSearch}>
            <input
              type="text"
              placeholder="Search books..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
            <button type="submit" className="search-btn">
              <FaSearch />
            </button>
          </form>

          <ul className="nav-links">
            <li><Link to="/">Home</Link></li>
            <li><Link to="/books">Books</Link></li>
            <li><Link to="/orders">Orders</Link></li>
            <li>
              <Link to="/cart" className="cart-link">
                <FaShoppingCart />
                <span className="cart-badge">{cartCount}</span>
              </Link>
            </li>
          </ul>

          <div className="nav-auth">
            <button onClick={() => setOpenLogin(true)} className="btn-login">Login</button>
            <Link to="/register" className="btn-register">Register</Link>
          </div>

        </div>
      </nav>
    </>
  );
}
