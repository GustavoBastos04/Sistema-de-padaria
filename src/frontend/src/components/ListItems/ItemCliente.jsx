import PropTypes from "prop-types";

function ItemCliente(props){

    const formatCurrency = (value) => {
        const formattedValue = Math.abs(value).toFixed(2).replace('.', ',');
        return value < 0 ? `- R$${formattedValue}` : `R$${formattedValue}`;
    }

    return (
        <tr>
            <td>{props.nome}</td>
            <td>{props.tipo_de_assinatura}</td>
            <td>{props.telefone}</td>
            <td>{props.email}</td>
            <td>{props.cep}</td>
            <td>{formatCurrency(props.total_gasto)}</td>
            <td>{formatCurrency(props.desconto)}</td>
            <td>{formatCurrency(props.total_com_desconto)}</td>
        </tr>
    )
}

ItemCliente.propTypes = {
    nome: PropTypes.string.isRequired,
    tipo_de_assintura: PropTypes.string.isRequired,
    telefone: PropTypes.string.isRequired,
    email: PropTypes.string.isRequired,
    cep: PropTypes.string.isRequired,
    total: PropTypes.number.isRequired,
    desconto: PropTypes.number.isRequired,
    total_c_desconto: PropTypes.number.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemCliente;