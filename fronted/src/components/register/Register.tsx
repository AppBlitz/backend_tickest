import { Input } from "@nextui-org/react";
import { useForm } from "react-hook-form";
import { registerUser } from "./register.ts";
import { Users } from "../../interface/User/UserInterface.ts";
function Register() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<Users>();

  return (
    <div className="">
      <form onSubmit={handleSubmit(registerUser)}>
        <div>
          <label>Nombre completo</label>
          <Input
            placeholder="Nombre completo"
            type="text"
            {...register("fullName", { required: true, maxLength: 60 })}
          />
          {errors.fullName?.type === "required" && (
            <p> El campo es requerido</p>
          )}
          {errors.fullName?.type === "maxLength" && (
            <p>El campo no puede tener más de 60 caracteres</p>
          )}
        </div>
        <div>
          <label>Número de cedula</label>
          <Input
            className="w-52 border-red-900"
            placeholder="Número de cedula"
            type="text"
            {...register("identificationNumber", {
              required: true,
              maxLength: 10,
              min: 8,
            })}
          />
          {errors.identificationNumber?.type === "required" && (
            <p> el campo es requerido</p>
          )}
          {errors.identificationNumber?.type === "maxLength" && (
            <p> Solo puede tener 10 caracteres como máximo</p>
          )}
          {errors.identificationNumber?.type === "min" && (
            <p>La cantida minima de caracteres permitidos son 8</p>
          )}
        </div>
        <div>
          <label>Correo electrónico</label>
          <Input
            placeholder="correo eléctronico"
            type="email"
            {...register("email", {
              required: true,
              pattern: /^[^\s@]+@[^\s@]+\.[^\s@]+$/i,
            })}
          />
          {errors.email?.type === "pattern" && (
            <p> Correo eléctronico invalido revisar</p>
          )}
          {errors.email?.type === "required" && <p>El cambo es requerido</p>}
        </div>
        <div>
          <label>Número de telefono</label>
          <Input
            placeholder="Número de telefono"
            type="text"
            {...register("phoneNumber", { required: true, min: 10 })}
          />
          {errors.phoneNumber?.type === "required" && (
            <p>El campo es requerido</p>
          )}
        </div>
        <div>
          <label>Dirección de residencia</label>
          <Input
            placeholder="Dirección de residencia"
            type="text"
            {...register("address", { required: true })}
          />
          {errors.address?.type === "required" && <p>El campo es requerido</p>}
        </div>
        <div>
          <label>Contraseña</label>
          <Input
            placeholder="Ingrese tu contraseña"
            type="text"
            {...register("password", { required: true, min: 8, maxLength: 30 })}
          />
          {errors.password?.type === "required" && <p>El campo es requerido</p>}
          {errors.password?.type === "min" && (
            <p> La contraseña no puede tener menos de 8 caracteres</p>
          )}
          {errors.password?.type === "maxLength" && (
            <p>
              La contraseña no puede tener una cantidad mayor de 30 caracteres
            </p>
          )}
        </div>
        <button> Crear</button>
      </form>
    </div>
  );
}
export { Register };
