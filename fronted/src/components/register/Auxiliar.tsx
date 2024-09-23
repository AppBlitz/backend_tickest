import { Address } from "./data/Address.tsx";
import { Email } from "./data/email.tsx";
import { Fullname } from "./data/fullName.tsx";
import { IdentificationNumber } from "./data/identificationNumber.tsx";
import { Password } from "./data/password.tsx";
import { PhoneNumber } from "./data/phoneNumber.tsx";
import { useContext } from "react";
import { UserContext } from "./context/UserContext.ts";
import { registerUser } from "./register.ts";
import { Users } from "../../interface/User/UserInterface.ts";

const Auxiliar = () => {
  const { User } = useContext(UserContext);
  function sendUser() {
    const user: Users = {
      email: User.email + "",
      fullName: User.fullName + "",
      identificationNumber: User.identificationNumber + "",
      address: User.address + "",
      phoneNumber: User.phoneNumber + "",
      password: User.password + "",
    };
    registerUser(user);
  }
  return (
    <div>
      <Email />
      <Fullname />
      <IdentificationNumber />
      <PhoneNumber />
      <Address />
      <Password />
      <div>
        <button onClick={() => sendUser()}>Register</button>
      </div>
    </div>
  );
};
export { Auxiliaar };
