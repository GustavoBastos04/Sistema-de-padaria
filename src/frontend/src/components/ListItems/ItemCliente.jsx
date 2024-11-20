import PropTypes from "prop-types";

function ItemCliente(props){
    return (
        <tr>
            <td>{props.nome}</td>
            <td>{props.cpf}</td>
            <td>{props.total}</td>
            <td>{props.desconto}</td>
            <td>{props.total_c_desconto}</td>
        </tr>
    )
}

ItemCliente.propTypes = {
    nome: PropTypes.string.isRequired,
    cpf: PropTypes.string.isRequired,
    total: PropTypes.number.isRequired,
    desconto: PropTypes.number.isRequired,
    total_c_desconto: PropTypes.number.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemCliente;