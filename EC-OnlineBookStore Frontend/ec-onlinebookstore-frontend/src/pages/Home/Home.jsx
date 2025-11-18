import "./Home.css";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div className="home-container">

      <div className="hero-section">
        <div className="hero-text">
          <h1>Welcome to EC-OnlineBookStore</h1>
          <p>Your one-stop destination for all book categories.</p>

          <Link to="/books" className="hero-btn">
            Browse Books
          </Link>
        </div>
      </div>

    </div>
  );
}
