import { Users } from "../../../interface/User/UserInterface";
import { UserContext } from "./UserContext";
import React from "react";

interface props {
  children: React.ReactNode;
}

const StateContext = ({ children }: props) => {
  const [User, setUser] = React.useState<Users>({
  });
  return (
    <UserContext.Provider value={{ User, setUser }}>
      {children}
    </UserContext.Provider>
  );
};
export { StateContext };
