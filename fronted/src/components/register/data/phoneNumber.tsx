
import { useForm } from "react-hook-form";
import { Users } from "../../../interface/User/UserInterface.ts"
import { UserContext } from "../context/UserContext";
import React from "react"
import { Input } from "@nextui-org/react";
const PhoneNumber = () => {

  const { setUser } = React.useContext(UserContext);
  const { register, handleSubmit } = useForm<Users>();

  const addName = (phoneNumber: string) => {
    setUser((prev) => {
      return { ...prev, phoneNumber: phoneNumber };
    })
  }
  const addUser = (user: Users) => {
    addName(user.phoneNumber + "");
  }
  return (<>
    <div>
      <form onSubmit={handleSubmit(addUser)}>
        <label>Contraseña</label>
        <Input type="text" {...register("phoneNumber", {
          required: true
        })} />
        <button>Click me</button>
      </form>
    </div>
  </>);
};
export { PhoneNumber };
