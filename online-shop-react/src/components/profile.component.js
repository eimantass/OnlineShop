import React, { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import { Link } from "react-router-dom";
import AuthService from "../services/auth.service";
import UserService from "../services/user.service";

const Profile = () => {
  const [redirect, setRedirect] = useState(null);
  const [userReady, setUserReady] = useState(false);
  const [customerData, setCustomerData] = useState("");
  const [currentUser, setCurrentUser] = useState({ username: "" });

  useEffect(() => {
    const currentUser = AuthService.getCurrentUser();
    // get user data by ID
    const customerData = UserService.getCustomerByIdMethod(currentUser.id)
    .then((response) => {
      setCustomerData(response.data);
    })

    if (!currentUser) {
      setRedirect("/home");
      
    } else {
      setCurrentUser(currentUser);
      setUserReady(true);
    }
  }, []);

  if (redirect) {
    return <Navigate to={redirect} />;
  }

  return (
    <div className="container">
      {userReady ? (
        <div>
          <header className="jumbotron">
            <h3>
              <strong>{currentUser.username}</strong> Profile
            </h3>
          </header>
          {/* No need to show token */}
          {/* <p>
            <strong>Token:</strong>{" "}
            {currentUser.accessToken.substring(0, 20)} ...{" "}
            {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
          </p> */}
          <p>
            <strong>Id:</strong> {currentUser.id}
          </p>
          <p>
            <strong>Email:</strong> {currentUser.email}
          </p>
          <p>
            <strong>Phone Number:</strong> {customerData.number}
          </p>
          <strong>Authorities:</strong>
          <ul>
            {currentUser.roles &&
              currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
          </ul>
          <strong>Money:</strong> {customerData.money}
          <div>
          <Link to={`/user-control/edit/${customerData.id}`} className="btn btn-primary mr-2">
                  Edit User Information
                </Link>
                </div>
                <br></br>
                <div>
          <Link to={`/user-order/${customerData.id}`} className="btn btn-success mr-2">
                  View Orders
                </Link>
                </div>

        </div>
        
        
      ) : null}
    </div>
  );
};

export default Profile;