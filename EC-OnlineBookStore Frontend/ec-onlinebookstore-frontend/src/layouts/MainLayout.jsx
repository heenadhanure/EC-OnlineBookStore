import { Outlet } from "react-router-dom";
import Navbar from "../components/Navbar/Navbar";
import Footer from "../components/Footer/Footer";

export default function MainLayout({ setOpenLogin }) {
  return (
    <>
      <Navbar setOpenLogin={setOpenLogin} />

      <div style={{ minHeight: "85vh" }}>
        <Outlet />
      </div>

      <Footer />
    </>
  );
}
