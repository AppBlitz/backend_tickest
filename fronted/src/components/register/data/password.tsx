import { useForm } from "react-hook-form";
import { Users } from "../../../interface/User/UserInterface.ts";
import { UserContext } from "../context/UserContext";
import React from "react";

import { Input } from "@nextui-org/react";
const Password = () => {
  const { setUser } = React.useContext(UserContext);
  const { register, handleSubmit } = useForm<Users>();

  const addName = (password: string) => {
    setUser((prev) => {
      return { ...prev, password: password };
    });
  };
  const addUser = (user: Users) => {
    addName(user.password + "");
  };
  return (
    <>
      <div>
        <form onSubmit={handleSubmit(addUser)}>
          <label>Contraseña</label>
          <Input
            type="text"
            {...register("password", {
              required: true,
            })}
          />
          <button>Click me</button>
        </form>
      </div>
    </>
  );
};
export { Password };
