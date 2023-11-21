package com.upc.FinanazasGrupo4.shared.helpers.Calculadora;

public class CalculadoraSeguroDesgravamen{

    public static double calcularSeguroDesgravamenConPrestamo(double montoPrestamo, double porcentajeSeguroDesgravamenMensual){
        double porcentajeConvertido= porcentajeSeguroDesgravamenMensual/100;
        return montoPrestamo * porcentajeConvertido;
    }

    public static double calcularTasaSeguroMensual(String tiempo, double porcentaje){

        String tiempoMayuscula = tiempo.toUpperCase();
        double nuevoPorcentaje=porcentaje;

        switch (tiempoMayuscula) {
            case "ANUAL":
                nuevoPorcentaje = porcentaje / 12;
                break;
            case "SEMESTRAL":
                nuevoPorcentaje = porcentaje/ 6;
                break;
            case "TRIMESTRAL":
                nuevoPorcentaje = porcentaje / 3;
                break;
                case "BIMESTRAL":
                nuevoPorcentaje = porcentaje / 2;
                break;
            case "MENSUAL":
                break;
            case "QUINCENAL":
                nuevoPorcentaje = porcentaje * 2;
                break;
            case "SEMANAL":
                nuevoPorcentaje = porcentaje * 4;
                break;
            case "DIARIA":
                nuevoPorcentaje = porcentaje * 30;
                break;
            default:
                nuevoPorcentaje = porcentaje;
                break;
        }

        return nuevoPorcentaje;
    }

    public static double calcularTasaSeguroConFrecuenciaPago(String frecuenciaPago, String PlazoSeguroDesgravamen, double porcentajeSeguroDesgravamen){

        double tasaMensualSeguroDesgravamen = calcularTasaSeguroMensual(PlazoSeguroDesgravamen, porcentajeSeguroDesgravamen);

        switch (frecuenciaPago.toUpperCase()){
            case "ANUAL":
                return tasaMensualSeguroDesgravamen * 12;
            case "SEMESTRAL":
                return tasaMensualSeguroDesgravamen * 6;
            case "TRIMESTRAL":
                return tasaMensualSeguroDesgravamen * 3;
            case "BIMESTRAL":
                return tasaMensualSeguroDesgravamen * 2;
            case "MENSUAL":
                return tasaMensualSeguroDesgravamen;
            case "QUINCENAL":
                return tasaMensualSeguroDesgravamen / 2;
            case "SEMANAL":
                return tasaMensualSeguroDesgravamen / 4;
            case "DIARIA":
                return tasaMensualSeguroDesgravamen / 30;
            default:
                return tasaMensualSeguroDesgravamen;
        }

    }


}
