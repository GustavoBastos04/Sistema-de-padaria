import PropTypes from "prop-types";

function ItemVenda(props){
    return (
        <tr>
            <td>{props.id_venda}</td>
            <td>{props.valor}</td>
            <td>{props.data}</td>
        </tr>
    )
}

ItemVenda.propTypes = {
    id_venda: PropTypes.string.isRequired,
    valor: PropTypes.string.isRequired,
    data: PropTypes.string.isRequired,
}

export default ItemVenda;