import { Input } from "@nextui-org/react";
import { useForm } from "react-hook-form";
import { Users } from "../../interface/User/UserInterface.ts";
import { api } from "../../api/api.ts";
function Register() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<Users>();

  const registerUser = (user: Users) => {
    api
      .post("/account/add", {
        fullName: user.fullName,
        email: user.email,
        address: user.address,
        password: user.password,
        phoneNumber: user.phoneNumber,
        identificationNumber: user.identificationNumber,
      })
      .catch((error) => {
        console.log("error" + error);
      })
      .finally();
  };
  return (
    <div>
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
          <label className="text-red-600">Dirección de residencia</label>
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
