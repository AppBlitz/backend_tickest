import App from "../App.tsx";
import { Register, Activate } from "../components/index.ts";
import { createBrowserRouter } from "react-router-dom";
import { PagineError } from "./errors.tsx";

const Router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/register",
    element: <Register />,
    errorElement: <PagineError />
  },
  {
    path: "/activate",
    element: <Activate />
  }
]);

export { Router };
