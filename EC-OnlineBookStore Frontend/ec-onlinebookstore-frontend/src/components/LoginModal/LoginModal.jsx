import React, { useState } from "react";
import "./LoginModal.css";
import { loginUser } from "../../apis/authService";
import { useNavigate } from "react-router-dom";

export default function LoginModal({ isOpen, onClose }) {
  const navigate = useNavigate();

  const [activeTab, setActiveTab] = useState("password"); // password | otp

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [otp, setOtp] = useState("");

  const [errors, setErrors] = useState({});

  if (!isOpen) return null;

  // -------------------------
  // VALIDATIONS
  // -------------------------
  const validateEmail = () => {
    if (!email.trim()) return "Email is required";
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email))
      return "Invalid email format";
    return null;
  };

  const validatePassword = () => {
    if (!password.trim()) return "Password is required";
    if (password.length < 6) return "Password must be at least 6 characters";
    return null;
  };

  const validateOtp = () => {
    if (!otp.trim()) return "OTP is required";
    if (!/^[0-9]{6}$/.test(otp)) return "OTP must be 6 digits";
    return null;
  };

  // -------------------------
  // HANDLE PASSWORD LOGIN (WITH TOKEN)
  // -------------------------
  const handlePasswordLogin = async () => {
    const emailErr = validateEmail();
    const passErr = validatePassword();

    if (emailErr || passErr) {
      setErrors({ email: emailErr, password: passErr });
      return;
    }

    try {
      const response = await loginUser({ email, password });

      if (response.status === 200) {
        // Save JWT token
        localStorage.setItem("token", response.data);

        alert("Login Successful!");

        // Close modal
        onClose();

        // Redirect to homepage
        navigate("/");
      } else {
        setErrors({ password: response.message || "Invalid Credentials" });
      }
    } catch (error) {
      setErrors({ password: "Invalid email or password" });
    }
  };

  // -------------------------
  // OTP LOGIN HANDLERS
  // -------------------------
  const handleOtpSend = () => {
    const emailErr = validateEmail();

    if (emailErr) {
      setErrors({ email: emailErr });
      return;
    }

    console.log("Send OTP to:", email);
    alert("OTP sent to your email!");
  };

  const handleOtpLogin = () => {
    const emailErr = validateEmail();
    const otpErr = validateOtp();

    if (emailErr || otpErr) {
      setErrors({ email: emailErr, otp: otpErr });
      return;
    }

    console.log("Login with OTP:", { email, otp });
    alert("Login Successful (OTP)");

    onClose();
    navigate("/");
  };

  return (
    <div className="modal-overlay">
      <div className="login-modal">
        <button className="close-btn" onClick={onClose}>×</button>

        <h2>Login</h2>

        {/* Tabs */}
        <div className="tabs">
          <button
            className={activeTab === "password" ? "active" : ""}
            onClick={() => {
              setActiveTab("password");
              setErrors({});
            }}
          >
            Email & Password
          </button>

          <button
            className={activeTab === "otp" ? "active" : ""}
            onClick={() => {
              setActiveTab("otp");
              setErrors({});
            }}
          >
            Login with OTP
          </button>
        </div>

        {/* Common Email Field */}
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>

        {/* PASSWORD LOGIN */}
        {activeTab === "password" && (
          <>
            <div className="form-group">
              <label>Password</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              {errors.password && <p className="error">{errors.password}</p>}
            </div>

            <button className="login-btn" onClick={handlePasswordLogin}>
              Login
            </button>
          </>
        )}

        {/* OTP LOGIN */}
        {activeTab === "otp" && (
          <>
            <button className="send-otp-btn" onClick={handleOtpSend}>
              Send OTP
            </button>

            <div className="form-group">
              <label>Enter OTP</label>
              <input
                type="text"
                value={otp}
                onChange={(e) => setOtp(e.target.value)}
              />
              {errors.otp && <p className="error">{errors.otp}</p>}
            </div>

            <button className="login-btn" onClick={handleOtpLogin}>
              Login with OTP
            </button>
          </>
        )}
      </div>
    </div>
  );
}
