import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { registerUser } from "../../apis/authService";
import "./Register.css";
import LoginModal from "../../components/LoginModal/LoginModal";

export default function Register() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    contactId: "",
    confirmPassword: "",
  });

  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);
  const [openLogin, setOpenLogin] = useState(false);
  
  // -------------------------
  // VALIDATION
  // -------------------------
  const validate = () => {
    const newErrors = {};

    if (!formData.firstName.trim()) newErrors.firstName = "First name is required";
    if (!formData.lastName.trim()) newErrors.lastName = "Last name is required";

    if (!formData.email.trim()) newErrors.email = "Email is required";
    else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email))
      newErrors.email = "Invalid email";

    if (!formData.password.trim()) newErrors.password = "Password is required";
    else if (formData.password.length < 6)
      newErrors.password = "Password must be at least 6 characters";

    if (!formData.confirmPassword.trim())
      newErrors.confirmPassword = "Confirm Password is required";
    else if (formData.password !== formData.confirmPassword)
      newErrors.confirmPassword = "Passwords do not match";

    if (!formData.contactId.trim())
      newErrors.contactId = "Contact is required";
    else if (!/^[0-9]{10}$/.test(formData.contactId))
      newErrors.contactId = "Contact must be 10 digits";

    return newErrors;
  };

  // -------------------------
  // SUBMIT HANDLER
  // -------------------------
  const handleSubmit = async (e) => {
    e.preventDefault();

    const validationErrors = validate();
    setErrors(validationErrors);

    if (Object.keys(validationErrors).length > 0) return;

    setLoading(true);

    try {
      // Prepare payload WITHOUT confirmPassword
      const payload = {
        firstName: formData.firstName,
        lastName: formData.lastName,
        email: formData.email,
        password: formData.password,
        contactId: formData.contactId,
      };

      const response = await registerUser(payload);

      alert("User Registered Successfully!");
      // open the login modal instead of navigating
      setOpenLogin(true);
    } catch (error) {
      alert(error.message || "Registration failed");
    } finally {
      setLoading(false);
    }
  };

  // -------------------------
  // INPUT CHANGE
  // -------------------------
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  return (
    <div className="register-container">
      <form onSubmit={handleSubmit} className="register-form">
        <h2>Create Account</h2>

        <div className="form-group">
          <label>First Name</label>
          <input name="firstName" value={formData.firstName} onChange={handleChange} />
          {errors.firstName && <p className="error">{errors.firstName}</p>}
        </div>

        <div className="form-group">
          <label>Last Name</label>
          <input name="lastName" value={formData.lastName} onChange={handleChange} />
          {errors.lastName && <p className="error">{errors.lastName}</p>}
        </div>

        <div className="form-group">
          <label>Email</label>
          <input name="email" value={formData.email} onChange={handleChange} />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>

        <div className="form-group">
          <label>Contact Number</label>
          <input name="contactId" value={formData.contactId} onChange={handleChange} />
          {errors.contactId && <p className="error">{errors.contactId}</p>}
        </div>

        <div className="form-group">
          <label>Password</label>
          <input type="password" name="password" value={formData.password} onChange={handleChange} />
          {errors.password && <p className="error">{errors.password}</p>}
        </div>

        <div className="form-group">
          <label>Confirm Password</label>
          <input
            type="password"
            name="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleChange}
          />
          {errors.confirmPassword && <p className="error">{errors.confirmPassword}</p>}
        </div>

        <button type="submit" className="btn-register" disabled={loading}>
          {loading ? "Registering..." : "Register"}
        </button>

        <p className="login-link">
          Already have an account? <a onClick={() => setOpenLogin(true)} className="login-text">Login</a>
        </p>
      
      </form>

      {/* Login modal opens after successful registration */}
      <LoginModal isOpen={openLogin} onClose={() => setOpenLogin(false)} />
    </div>
  );
}
